package com.doobangframework.springboot_simple;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * simple
 * 
 * @author changyong
 *
 */
@SpringBootApplication
public class SimpleApplication extends WebMvcConfigurerAdapter {
	private static Logger log = LoggerFactory.getLogger(SimpleApplication.class);

	private static String envName;

	@Value("${spring.profiles.active}")
	private String env;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SimpleApplication.class, args);
		log.info("服务启动完成：" + envName);
	}

	/**
	 * 
	 * 功 能： <br />
	 * 加载http请求拦截器，例如：登录状态校验等<br />
	 * ----------------------------------------------------------------<br />
	 * 修改记录 ：<br />
	 * 日 期 版本 修改人 修改内容<br />
	 * 2017年4月11日 v0.0.1 changyy 创建<br />
	 * ----------------------------------------------------------------<br />
	 * 
	 * @param registry
	 * <br />
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
	}

	@PostConstruct
	public void init() {
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
