# Project_WebChat
Implementing web chat room with functions of group chat, private chat, registration, etc.

功能：用户进行注册、登陆，便可跳转到聊天界面进行信息的发送（聊天界面可看在线用户、收到的信息以及发送者用户名）。
模块：注册、登陆、聊天（群聊、私聊）
技术：Druid、JDBC、MVC 设计模式、Servlet 等。

# 实现
1. 基于MVC设计模式，划分dao层、service层和controller层，每一层有实现类和本层接口类。
2. 使用alibaba的Druid数据库连接池管理连接，通过JDBC对MySQL数据库进行操作。
3. webSocket对浏览器和服务器之间的连接、断开连接、发送信息功能进行实现。
4. 通过@webServlet的urlPatterns值与前端的界面进行关联，从而对浏览器的可视化界面进行控制。
5. @WebListener实现了监听器的功能，对聊天页面的会话进行监听。将工程导出war包上传至阿里云轻量级服务器， 启动tomcat运行。 

下面是服务器地址，欢迎访问http://39.107.118.86:8088

# 测试方面
1. 对这个项目我做了一些测试，开发阶段我使用JUnit框架进行单元测试，随后开始使用黑盒+白盒测试对集成好的系统的接口进行测试（包括web接口和内部接口）
2. 接着用了等价类、边界值法、场景法进行测试用例的编写，测试用例包括了功能方面、性能方面、兼容以及容错性。
3. 对这个项目我使用Selenium+Python对登陆、注册进行了简单的自动化测试。
4. 使用LoadRunner和JMeter进行了性能测试和压力测试，主要对吞吐量、错误率、响应时间进行监控。

# 测试结果在这里~
在这个文件里的https://github.com/ZhiningHe/Project_WebChat “测试整理文件”文件夹里，有我测试的结果。

