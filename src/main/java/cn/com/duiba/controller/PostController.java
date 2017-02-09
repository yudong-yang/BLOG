package cn.com.duiba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.duiba.entity.Post;
import cn.com.duiba.service.CommentJpaService;
import cn.com.duiba.service.PostJpaService;

@Controller
@RequestMapping("/posts")
public class PostController {
	@Autowired
    private PostJpaService postService;
	@Autowired
    private CommentJpaService commentService;
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreatePage() {
        return "blog/create";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id ,Model model) {
    	if(id==0)
    	{id=1;}else{}
    	Post post = postService.getByid(id);
    	 model.addAttribute("post", post);
    	 model.addAttribute("comments", commentService.findbyPostId(id));
    	return "blog/post";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCreate(@ModelAttribute("post") Post post) {
    	postService.save(post);
        return "redirect:/posts/"+post.getId();
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("posts", postService.findAllPost());
        return "blog/index";
    }
}
