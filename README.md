# plaza-master

# 修改maven配置
# 项目启动之前先安装redis和rabbitmq
# 链路追踪使用的zipkin，需要使用docker下载镜像并启动 
# 本项目只有eureka服务制作了docker启动的镜像文件，使用docker创建发布即可
# 其他的需要制作镜像文件可以参考eureka中的Dockerfile

# 本项目使用到了fegin，hystrix，config，zipkin，admin，zuul，aouth2，tx-lcn，stream等
#（数据库配置文件放在github中），采用JCE（参考官网）非对称加密的方式
# 下载需要修改plaza-discovery中的github连接配置
# 修改plaza-provider中所有项目的数据库连接配置，修改redis、rabbitmq配置
# tx-lcn分布式事物需要修改redis配置，以及注册中心配置
# 修改plaza-oauth修改数据库配置
# 修改plaza-discovery中的plaza-discovery-omc中的tx.manager-url和zipkin地址