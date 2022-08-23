## 技能交易平台
**项目采用微服务方式开发，单个服务使用SpringBoot+MyBatis开发，主要包含以下服务：basics、eureka、recruit、resume、web。**
父工程负责管理依赖和版本、聚合子工程。
### basics
抽取出每个服务都会用到的通用代码，如响应类型、统一日志管理，供其他服务调用。
### eureka
注册中心（可以是集群）。
所有的服务都向eureka注册信息，服务调用者（web）向eureka寻找可用的微服务的信息并调用。
#### 负载均衡Ribbon
eureka自带负载均衡策略，无需配置，直接在Web添加**@LoadBanlance**注解，即可，Ribbon会根据服务名来调用对应的服务。在application.properties文件中可以指定负载均衡策略是随机还是轮询。

系统每个用户都可以有两种角色：need和provide，技能需求者和技能提供者，每个user都有两种身份，不同的身份对应不同的操作界面。
### recruit
对用户提供的操作：

 - 查询所有provide的具体信息
 - 查询所有need的简历

### resume
主要针对简历管理操作：

 - 简历上传
 - 查询所有的简历
 - 显示简历分数
 - 查询单个简历详情
 
### web
我们提供一个web服务作为服务调用者。服务间的调用使用RestTemplate对象，只需提供被调用者的url和参数即可
