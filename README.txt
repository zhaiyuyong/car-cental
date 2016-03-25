1、config
   配置层
2、controller 
   接口层
3、domain
   域层与数据库表对应
4、net
  网络层 监听11000端口 接收tcp链接
5、persistence
  数据库操作层
6、service
  业务逻辑层 聚合各种数据库操作和一些计算
7、CarApplication
   进程入口

8、intg文件夹
   开发环境配置
9、prod
   生成环境配置
10、logback.xml
   进程打印日志配置
11、sql文件夹
   数据库表scheme
   
12、web服务监听端口 8080

打包命令：
   cd car-ental
   gradle clean build
   
   jar文件在  car-ental/build/lib
启动命令：
   nohup java -jar  -Dspring.profiles.active=intg  car-ental-1.0.0.jar  >/dev/null  2>&1 &
   
开发环境
  1、jdk 1.8
  2、gradle version2.3+
  3、eclipse
  
   