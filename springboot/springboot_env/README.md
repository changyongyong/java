# 根据系统环境变量启动不同环境的服务

该方式是打包个环境都一样，启动时候根据系统环境变量启动不同环境服务
该方式一般发布版本之后根据自动化系统启动
也可以直接发布docker镜像，启动docker注入系统环境变量来启动不同服务

## 启动docker命令
``` bash
$ docker run -d -e PROFILES_ACTIVE=pre
```
-e 参数为设置docker容器系统变量    
PROFILES_ACTIVE即为变量配置key   

具体查看docker使用教程