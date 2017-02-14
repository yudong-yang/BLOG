package cn.com.duiba.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.duiba.entity.Person;
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
        try {
        	userJpaservice.deleteByid(Integer.parseInt(userid));
        	return "success";
		} catch (Exception e) {
			return "fail"+e;
		}
    }
    @RequestMapping("/update")
    public String UpdatePerson(HttpServletRequest request, Model model){
    	String personid=request.getParameter("personid");
    	String page=request.getParameter("page");
        System.out.println("跳转更新页面"); 
         model.addAttribute("user", userJpaservice.findById(Integer.parseInt(personid)));
         model.addAttribute("page", page);
         return "update";
    }
    
    @RequestMapping(value = "/save/{page}", method = RequestMethod.POST)
    public String Save(@PathVariable("page") int page,Person person, Model model) {
    	model.addAttribute("user", person);
    	userJpaservice.UpdatePerson(person);
        return "redirect:/users/page?page="+page;
    }
    
    
    @RequestMapping(value = "/bachsave/{num}", method = RequestMethod.GET)
    @ResponseBody
    public String BachSave(@PathVariable("num") int num) {
    	List<Person> persons =new ArrayList<Person>();
    	for (int i = 0; i < num; i++) {
			Person p1 = new Person("张晓明","12457");
			Person p2 = new Person("王晓丽","12457");
			Person p3 = new Person("李三星","12457");
			Person p4 = new Person("赵思成","12457");
			Person p5 = new Person("李武阁","12457");
			persons.add(p1);
			persons.add(p2);
			persons.add(p3);
			persons.add(p4);
			persons.add(p5);
		}
    	userJpaservice.BachSave(persons);
		return "success";
    	
    }
    
    @RequestMapping(value = "/bachdel/{num}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public String Bachdel(@PathVariable("num") int num) {
    	List<Person> persons =new ArrayList<Person>();
    	for (int i = 1100; i < 2100; i++) {
    		persons.add(userJpaservice.getByid(i));
		}
    	System.out.println("长度==="+persons.size());
    	userJpaservice.Bachdel(persons);
		return "success";
    	
    }
    
}
