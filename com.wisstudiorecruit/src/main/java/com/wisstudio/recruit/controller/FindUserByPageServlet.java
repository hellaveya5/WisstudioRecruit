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

        Map<String, String[]> condition = req.getParameterMap();
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        if(currentPage ==null || "".equals(currentPage) ){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "5" ;
        }
        if(!"0".equals(currentPage)){
            resp.setContentType("text/html;charset = utf-8");
            UserServiceImpl service = new UserServiceImpl();
            PageBean<User> pb = service.findUserByPage(currentPage , rows , condition);
            //请求的页数大于应有的页数，拒绝
            ObjectMapper objectMapper = new ObjectMapper();
            String pbData = objectMapper.writeValueAsString(pb);
            System.out.println(pbData);
            resp.getWriter().write(pbData);
            if((pb.getTotalPage() < Integer.parseInt(currentPage))){
                Logger.getGlobal().info("没有该数据");
            }
        }else {
            Logger.getGlobal().info("请求的页数大于等于0：错误的寻页索引");
        }
        }


    }

