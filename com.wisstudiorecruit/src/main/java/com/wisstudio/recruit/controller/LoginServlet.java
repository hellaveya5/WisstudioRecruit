package com.wisstudio.recruit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.result.ResultInfo;
import com.wisstudio.recruit.service.Impl.UserServiceImpl;
import com.wisstudio.recruit.service.UserService;
import com.wisstudio.recruit.util.BeanUtils;
import com.wisstudio.recruit.util.Impl.BeanUtilsImpl;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        BeanUtils beanUtils = new BeanUtilsImpl();
        User user=beanUtils.populate(User.class,map);
        User u = new UserServiceImpl().login(user);
        ResultInfo info = new ResultInfo();
        if (u == null) {
            info.setFlag(false);
            System.out.println(info.isFlag());
            info.setMsg("用户名密码错误");
            Logger.getGlobal().info(info.getMsg());
        } else {
            info.setFlag(true);
            info.setMsg("用户"+u.getName()+"登录");
            Logger.getGlobal().info(info.getMsg());
        }
        //响应数据
        ObjectMapper mapper = new ObjectMapper();
        String us = mapper.writeValueAsString(u);
        resp.getWriter().write(us);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
