package cn.com.duiba.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.duiba.service.PersonJpaService;


@Controller
@RequestMapping("/users")
public class PersonController {
	
	
	@Autowired
private PersonJpaService userJpaservice;

    @RequestMapping(value = "/page", method=RequestMethod.GET)
//    @ResponseBody
    public String getEntryByPageable(@PageableDefault(value = 15, sort = { "id" }, 
    direction = Sort.Direction.DESC) Pageable pageable,Model model) {
    	model.addAttribute("userLists", userJpaservice.GetUsersPage(pageable));
        return "listall";
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public String DeleteByid(HttpServletRequest request){
    	String userid=request.getParameter("userid");
        System.out.println("删除指定元素");
         userJpaservice.deleteByid(Integer.parseInt(userid));
         return "删除成功";
    }
    
}
