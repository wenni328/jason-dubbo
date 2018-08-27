# 解说
- springboot2.0.4版本整合dubbo2.6.2，采用的是dubbo-spring-boot-starter

- 实体与接口做了分离（避免单机上会认为实现和接口是一起的），最终生产者和
消费者都依赖于api.

- 使用dubboadmin观察生产者和消费者服务状态

- 本例使用了mybatis和mysql数据库

- log4j2日志配置记录