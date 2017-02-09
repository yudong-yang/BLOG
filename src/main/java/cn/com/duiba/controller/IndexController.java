package cn.com.duiba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.duiba.entity.Post2;
import cn.com.duiba.repository.PostRepository;


@Controller
public class IndexController {
	/*   
    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("posts", postRepository.findAll());

        return "index";
    }
	    
    @RequestMapping(value = "/post2", method = RequestMethod.GET)
    public String post2() {
       

        return "post2";
    }
    
    @RequestMapping(value = "/saves", method = RequestMethod.POST)
    @ResponseBody
    public String saves(@RequestParam("title") String title,@RequestParam("subtitle") String content) {
       System.out.println(title+"=="+content);

        return title+"=="+content;
    }
    
    @RequestMapping(value = "/saves", method = RequestMethod.POST)
    @ResponseBody
    public String saves(Post2 post2) {
     
        return post2.getContent()+"=="+post2.getTitle();
    }*/
    
	}

