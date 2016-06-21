package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.util.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class UserController {
    JsonMapper nonNullBinder = JsonMapper.nonEmptyMapper();
	@Autowired
	private UserService userService;


    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public ModelAndView index(User user){
    	userService.insertUser(user);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/form");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public String find(){
        return "view/user/user_list";
    }
    @RequestMapping(value = "/find",method = RequestMethod.POST)
    @ResponseBody
    public String list(){
        List<User> users=userService.userList();
        return nonNullBinder.toJson(users);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public String delete(int id){
        userService.deleteById(id);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("success", true);
        return nonNullBinder.toJson(map);
    }
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ResponseBody
    public String findById(int id){
        return nonNullBinder.toJson(userService.findById(id));
    }
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(User user){
        userService.updateUser(user);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("success",true);
        return nonNullBinder.toJson(map);
    }
}