package cn.com.duiba.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.duiba.entity.Comment;
import cn.com.duiba.service.CommentJpaService;

@Controller
@RequestMapping("/comments")
public class CommentController {
	@Autowired
    private CommentJpaService commentService;
  

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String saveCreate(@ModelAttribute("comment") Comment comment) {
    	System.out.println(comment.getContent()+"===="+comment.getId());
    	commentService.SaveComment(comment);
    	String id = commentService.findbyDate(comment.getCreated()).getId()+"";
        return "{'created':'"+DateToFomat(comment.getCreated())+"','id':'"+id+"'}";
    }
    
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("id") int id ) {
    	commentService.deleteByid(id);
		return "success";
    }
    
    
    public static String DateToFomat(Date date) {
		Date d=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(d);
		return time;
	}
}
