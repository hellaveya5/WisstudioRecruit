package com.wisstudio.recruit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisstudio.recruit.dao.Impl.UserDaoImpl;
import com.wisstudio.recruit.dao.UserDao;
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
import java.util.logging.Logger;
/**
 * @Author:98333
 * @Date:2021/4/20
 * @Description:com.wisstudio.recruit.controller
 */

@WebServlet(urlPatterns = "/getUserDataServlet")
public class GetUserDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        BeanUtils beanUtils = new BeanUtilsImpl();
        User user = beanUtils.populate(User.class, req.getParameterMap());
        System.out.println("/getUserDataServlet" + user);
        User userdata = new UserServiceImpl().findByUsernameAndPassword(user.getName(), user.getPassword());
        if(userdata!=null){
            ObjectMapper objectMapper = new ObjectMapper();
            String us = objectMapper.writeValueAsString(userdata);
            System.out.println(us);
            resp.getWriter().write(us);
            Logger.getGlobal().info("返回用户数据成功");
        }else {
            Logger.getGlobal().info("返回数据失败");
            info.setFlag(false);
            resp.getWriter().print(info.isFlag());
        }

    }



}
