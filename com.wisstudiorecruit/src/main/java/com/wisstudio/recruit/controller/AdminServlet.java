package com.wisstudio.recruit.controller;

import com.wisstudio.recruit.dao.Impl.AdminDaoImpl;
import com.wisstudio.recruit.po.Administrator;
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
 * @author 98333
 */
@WebServlet(urlPatterns = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        AdminDaoImpl adminDao = new AdminDaoImpl();
        BeanUtilsImpl beanUtils = new BeanUtilsImpl();
        Map<String, String[]> map = req.getParameterMap();
        Administrator ad = beanUtils.populate(Administrator.class, map);
        Administrator admin=adminDao.login(ad.getName(),ad.getPassword());
        if(admin!=null){
            info.setFlag(true);
            info.setMsg("登录管理员成功");
            Logger.getGlobal().info(info.getMsg());
            resp.getWriter().print(info.isFlag());
        }else{
            info.setFlag(false);
            info.setMsg("登录管理员失败");
            Logger.getGlobal().info(info.getMsg());
            resp.getWriter().print(info.isFlag());
        }
    }
}
