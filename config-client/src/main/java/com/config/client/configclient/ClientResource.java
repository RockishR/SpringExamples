package com.config.client.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/greet")
public class ClientResource {

	@Value("${my.greeting}")
	private String val;
	
	@GetMapping("/{greet}")
	public String msg(@PathVariable("greet") String msg) {
		
		return val;
	}
	
}
