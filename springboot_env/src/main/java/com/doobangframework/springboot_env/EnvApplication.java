package com.doobangframework.springboot_env;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class EnvApplication extends WebMvcConfigurerAdapter {

	private static Logger log = LoggerFactory.getLogger(EnvApplication.class);

	private static String envName;

	@Value("${spring.profiles.active}")
	private String env;

	/**
	 */
	public static void main(String[] args) {
		SpringApplication.run(EnvApplication.class, args);
		log.info("服务启动完成：" + envName);
	}

	@PostConstruct
	public void init() {
		System.out.println(env);
		switch (env) {
		case "dev":
			envName = "开发环境";
			break;
		case "test":
			envName = "测试环境";
			break;
		case "pre":
			envName = "预发布环境";
			break;
		case "pro":
			envName = "生产环境";
			break;
		default:
			break;
		}
	}

}
