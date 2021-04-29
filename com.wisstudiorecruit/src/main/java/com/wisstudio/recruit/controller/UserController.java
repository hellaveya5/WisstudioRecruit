package com.wisstudio.recruit.controller;

import com.wisstudio.Annotation.GetMapping;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.vo.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:98333
 * @Date:2021/4/29
 * @Description:com.wisstudio.recruit.controller
 */
public class UserController {
    @GetMapping("/modify")
    public ModelAndView modify(){

        return null;
    }
    @GetMapping("/signIn")
    public ModelAndView login(){
        return null;

    }
    @GetMapping("/register")
    public ModelAndView register(){
        return null;
    }
    @GetMapping("/user/profile")
    public ModelAndView profile(HttpServletRequest req , HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null ){
            return new ModelAndView("redirect:/signIn");
        }
        //判断权限 返回403  ，待实现
        Map map = new HashMap<String , User>();
        map.put("user",user);
        return new ModelAndView( map,"/profile.html" );
    }
}
