package com.wisstudio.recruit.controller;

import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.result.ResultInfo;
import com.wisstudio.recruit.service.Impl.UserServiceImpl;
import com.wisstudio.recruit.util.BeanUtils;
import com.wisstudio.recruit.util.Impl.BeanUtilsImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/RegistServlet")
public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        BeanUtils beanUtils = new BeanUtilsImpl();
        ResultInfo info = new ResultInfo();
        User user = beanUtils.populate(User.class, map);
        //flag成功与否
        boolean flag = new UserServiceImpl().regist(user);
        System.out.println("servlet"+flag);
        if(flag){
            resp.getWriter().write("注册成功");

            Logger.getGlobal().info("注册成功");
        }else {
            resp.getWriter().write("注册失败");
            Logger.getGlobal().info("注册失败");
        }
    }
}
