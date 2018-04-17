package com.doobangframework.springboot_simple.http.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class SimpleController extends BaseController {

	private static Logger log = LoggerFactory.getLogger(SimpleController.class);

	@GetMapping(value = "/test")
	public String test() {
		return "ok";
	}

	@GetMapping(value = "/t")
	public String t() {
		log.trace("==================trace======================");
		log.debug("==================debug==================");
		log.info("==================info==================");
		log.warn("==================warn==================");
		log.error("==================error==================");
		return "ok1";
	}

}
