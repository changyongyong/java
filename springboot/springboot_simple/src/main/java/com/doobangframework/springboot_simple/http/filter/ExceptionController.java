package com.doobangframework.springboot_simple.http.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.doobangframework.springboot_simple.result.ResultEntity;
import com.doobangframework.springboot_simple.result.ServiceCode;
import com.doobangframework.springboot_simple.result.ServiceException;
import com.doobangframework.springboot_simple.util.GsonUtil;

@ControllerAdvice
public class ExceptionController {

	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	// 业务自定义异常
	@ExceptionHandler(value = ServiceException.class)
	public void processUnauthenticatedException(HttpServletResponse response,
			ServiceException serviceException) {
		try {
			logger.info("请求服务异常结果：", serviceException);
			printMsg(response, serviceException.getCode(), serviceException.getErrMsg());
		} catch (Exception e) {
			logger.error("ServiceException异常流输出异常：", e);
		}
	}

	// 其他异常
	@ExceptionHandler(value = Exception.class)
	public void processUnauthenticatedException(HttpServletResponse response, Exception exception) {
		try {
			logger.error("请求异常：", exception);
			printMsg(response, ServiceCode.SYSTEM_EXCEPTION, exception.getLocalizedMessage());
		} catch (Exception e) {
			logger.error("Exception异常流输出异常：", e);
		}
	}

	private void printMsg(HttpServletResponse response, Integer errorCode, String errorMsg) {
		try {
			ResultEntity resultEntity = new ResultEntity(errorCode, errorMsg);
			resultEntity.setData(null);
			response.setCharacterEncoding("UTF-8");
			response.getOutputStream().write(GsonUtil.GsonString(resultEntity).getBytes("UTF-8"));
		} catch (Exception e) {
			logger.error("异常流输出异常：", e);
		}
	}

}
