# 前言
- 本例使用springboot+mybatis+多数据源（双库）
做了一个简单的例子。
唯一值得注意的是springboot2.0之后，url的配置不一样了。
```properties
# 2.0之前
spring.datasource.master.url=jdbc:mysql://localhost:3306/data?useUnicode=true&amp;characterEncoding=utf8;allowMultiQueries=true&&useSSL=true

#springboot2.0后
spring.datasource.master.jdbc-url=jdbc:mysql://localhost:3306/data?useUnicode=true&amp;characterEncoding=utf8;allowMultiQueries=true&&useSSL=true

useSSL=true开启去除数据库连接警告
msyql5.5.45+ 要求连接建立在非明文情况下

```