package cn.com.duiba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/blog")
	public String blog() {
	    return "index";
	}

	@RequestMapping("/create")
	public String create() {
	    return "create";
	}

}
