package com.wisstudio.recruit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisstudio.recruit.dao.Impl.AdminDaoImpl;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.result.ResultInfo;
import com.wisstudio.recruit.util.Impl.BeanUtilsImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author:98333
 * @Date:2021/4/20
 * @Description:com.wisstudio.recruit.controller
 */
@WebServlet(urlPatterns = "/AdminSearchServlet")
public class AdminSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        AdminDaoImpl adminDao = new AdminDaoImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> allUser = adminDao.findAll();
        String allUs = objectMapper.writeValueAsString(allUser);
        resp.setContentType("text/html;charset = utf-8");
        resp.getWriter().write(allUs);

    }
}
