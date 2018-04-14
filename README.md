# LTEB-Session
一、实现一个LTE-B的Session发送器(client端)
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

二、接口信息：

1. Session 控制请求的操作类型和URL:

POST http://<服务器地址加端口>/nbi/deliverysession?id=<DeliverySessionId>

2. HTTP Body schema 定义:

<?xml version="1.0" encoding="utf-8"?>

<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">

<xsd:element name="DeliverySession" type="DeliverySessionCreationType"/>

<xsd:complexType name="DeliverySessionCreationType">

<xsd:sequence>

<xsd:element name="DeliverySessionId" type="xsd:unsignedInt"/>

<xsd:element name="Action" type="ActionType"/>

<xsd:choice>

<xsd:element name="TMGIPool" type=" xsd:string "/>

<xsd:element name="TMGI" type=" xsd:string "/>

</xsd:choice>

<xsd:element name="StartTime" type="xsd:unsignedInt" minOccurs="0"/>

<xsd:element name="StopTime" type="xsd:unsignedInt" minOccurs="0"/>

</xsd:sequence>

<xsd:attribute name="Version" type="xsd:string" use="required"/>

</xsd:complexType>

<xsd:simpleType name="ActionType">

<xsd:restriction base="xsd:string">

<xsd:enumeration value="Start"/>

<xsd:enumeration value="Stop"/>

</xsd:restriction>

</xsd:simpleType>

</xsd:schema>

Note:

请使用body 中的 ActionType 来表示是start还是stop

body 中DeliverySessionId 和url中的id 参数值是一致的
