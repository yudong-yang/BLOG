package cn.com.duiba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.duiba.entity.Comment;
import cn.com.duiba.entity.Post;
import cn.com.duiba.service.CommentJpaService;

@Controller
@RequestMapping("/comments")
public class CommentController {
	@Autowired
    private CommentJpaService commentService;
  

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCreate(@ModelAttribute("comment") Comment comment) {
    	commentService.SaveComment(comment);
        return "redirect:/posts/"+comment.getPost().getId();
    }
}
