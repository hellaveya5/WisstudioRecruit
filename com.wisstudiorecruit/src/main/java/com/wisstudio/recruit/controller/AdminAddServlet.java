package com.wisstudio.recruit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisstudio.Annotation.GetMapping;
import com.wisstudio.recruit.dao.Impl.AdminDaoImpl;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.result.ResultInfo;
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

/**
 * @Author:98333
 * @Date:2021/4/20
 * @Description:com.wisstudio.recruit.controller
 */

@WebServlet("/AdminAddServlet")
public class AdminAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @GetMapping(name = "/adminAdd")
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        BeanUtilsImpl beanUtils = new BeanUtilsImpl();
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Map<String, String[]> map = req.getParameterMap();
        System.out.println(map.toString());
        User user = beanUtils.populate(User.class,map);
        info.setFlag(adminDao.addUser(user));
        if(info.isFlag()){
            info.setMsg("增加用户成功");
        }else {
            info.setMsg("增加用户失败");
        }
        Logger.getGlobal().info(info.getMsg());
        resp.getWriter().write(info.getMsg());
        resp.sendRedirect("/AdminSearchServlet");
    }


}
