# 前言
- 本例使用springboot+mybatis+多数据源（双库）
做了一个简单的例子。
唯一值得注意的是springboot2.0之后，url的配置不一样了。
```properties
# 2.0之前
spring.datasource.master.url=jdbc:mysql://localhost:3306/data?useUnicode=true&amp;characterEncoding=utf8;allowMultiQueries=true&&useSSL=true

# springboot2.0后
spring.datasource.master.jdbc-url=jdbc:mysql://localhost:3306/data?useUnicode=true&amp;characterEncoding=utf8;allowMultiQueries=true&&useSSL=true

useSSL=true开启去除数据库连接警告
msyql5.5.45+ 要求连接建立在非明文情况下

```

# 配置多数据源是为了解决什么问题
-
现实业务场景中，为了保障客户体验并满足业务的线性增长。会对数据量巨大，且业务会始终进行的产品进行分表分库策略。但是如何合理的根据业务采取争取的分表分库策略至关重要

# 业务技术延伸

> 实现数据的读写分离，两个数据库的数据同步问题解决思路
- 打开mysql的配置文件
```bazaar
vim /etc/my.cnf
```
- 在主服务器master上配置开启Binary log，主要是在[mysqld]下面添加：

```properties

server-id=1
log-bin=master-bin
log-bin-index=master-bin.index
```

- 重启mysql服务

- 检查配置效果，进入主数据库并执行

```properties

mysql> SHOW MASTER STATUS;
```
记录此时的file名称，会在从数据库配置用到

- 从服务器配置my.conf

> 在[mysqld]节点下面添加： 
```properties

server-id=2
relay-log-index=slave-relay-bin.index
relay-log=slave-relay-bin
```
- 重启服务

# 配置两个数据库的关联关系

> 切换到主数据库执行

```properties
mysql> create user repl;
mysql> GRANT REPLICATION SLAVE ON *.* TO 'repl'@'从xxx.xxx.xxx.xx' IDENTIFIED BY 'mysql';
mysql> flush privileges;
```
这个配置的含义就是创建了一个数据库用户repl，密码是mysql, 在从服务器使用repl这个账号和主服务器连接的时候，就赋予其REPLICATION SLAVE的权限， *.* 表面这个权限是针对主库的所有表的，其中xxx就是从服务器的ip地址。 
进入从数据库后执行：

```properties
mysql> change master to master_host='主xxx.xxx.xxx.xx',master_port=3306,master_user='repl',master_password='mysql',master_log_file='master-bin.000001',master_log_pos=0;
```

这里面的xxx是主服务器ip，同时配置端口，repl代表访问主数据库的用户，上述步骤执行完毕后执行start slave启动配置：

```properties

mysql> start slave;
```
