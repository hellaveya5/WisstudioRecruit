package com.wisstudio.recruit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisstudio.recruit.dao.Impl.AdminDaoImpl;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.result.ResultInfo;
import com.wisstudio.recruit.service.Impl.AdminServiceImpl;
import com.wisstudio.recruit.util.Impl.BeanUtilsImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author:98333
 * @Date:2021/4/20
 * @Description:com.wisstudio.recruit.controller
 */
@WebServlet(urlPatterns = "/AdminDeleteServlet")
public class AdminDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        ResultInfo info = new ResultInfo();
        BeanUtilsImpl beanUtils = new BeanUtilsImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String[]> map = req.getParameterMap();
        User user = beanUtils.populate(User.class, map);
        info.setFlag((new AdminServiceImpl().delete(user.getStudentId())));
        //重定向到展示页面
        resp.sendRedirect("/AdminSearchServlet");
        if(info.isFlag()){
            info.setMsg("删除成功");
        }else {
            info.setMsg("删除失败");
        }resp.getWriter().write(info.getMsg());
    }
}
