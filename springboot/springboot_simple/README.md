# 根据配置打包不同环境的包

该中方式打包的时候就把环境区分，适合手动部署小工程

## 打包命令
``` bash
$ mvn clean package -DskipTests -Ptest
```

-P后边为参数，不同环境dev（开发） test（测试） pre（预发布内测） pro（生产）
