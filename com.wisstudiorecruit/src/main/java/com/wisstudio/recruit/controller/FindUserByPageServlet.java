package com.wisstudio.recruit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisstudio.recruit.po.PageBean;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.service.Impl.UserServiceImpl;
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
 * @Date:2021/4/24
 * @Description:com.wisstudio.recruit.controller 接收请求参数，调用Service查询，resp输出到页面
 */
@WebServlet(urlPatterns = "/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        if(!"0".equals(currentPage)){
            String rows = req.getParameter("rows");
            resp.setContentType("text/html;charset = utf-8");
            UserServiceImpl service = new UserServiceImpl();
            PageBean<User> pb = service.findUserByPage(currentPage,rows);
            if(pb.getTotalPage()<Integer.parseInt(currentPage)){
                Logger.getGlobal().info("错误的寻页索引");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String pbData = objectMapper.writeValueAsString(pb);
            resp.getWriter().write(pbData);
        }else {
            Logger.getGlobal().info("错误的寻页索引");
        }

    }
}
