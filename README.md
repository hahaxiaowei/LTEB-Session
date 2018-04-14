# LTEB-Session
实现一个LTE-B的Session发送器(client端)
1. 根据接口描述和协议类型(见下一节)发送 session start/stop请求给服务端

2. 可支持同时(向同一个server)并发发送多个请求

3. Stop请求需要根据session 时长来发送

4. 创建日志来记录session 状态 (发送时间,发送url,和body,结果,连接信息)

5. 提供readme说明项目情况以及如何编译，运行和配置，提供编译通过的信息。

6. 加分项目:

a. 支持异步发送 ，并提供方案说明

b. 支持动态调整并发参数，

c. 支持动态调整所有session时长

d. 有异常处理

e. 可优雅停止(比如等所有session stop后再退出)
