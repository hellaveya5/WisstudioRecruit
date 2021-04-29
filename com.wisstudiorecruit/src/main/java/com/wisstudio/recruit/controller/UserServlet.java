package com.wisstudio.recruit.controller;

import com.wisstudio.recruit.dao.Impl.UserDaoImpl;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.result.ResultInfo;
import com.wisstudio.recruit.service.Impl.UserServiceImpl;
import com.wisstudio.recruit.util.Impl.BeanUtilsImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.function.DoubleToIntFunction;
import java.util.logging.Logger;

/**
 * @author 98333
 */
@WebServlet( urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        BeanUtilsImpl beanUtils = new BeanUtilsImpl();
        /*User user = new User();*/
        Map<String, String[]> map = req.getParameterMap();
        User user = beanUtils.populate(User.class, map);
        System.out.println(user);
        info.setFlag(new UserServiceImpl().modify(user));
        if(info.isFlag()){
            info.setMsg("修改用户成功");
        }else{
            info.setMsg("修改用户失败");
        }
        Logger.getGlobal().info(info.getMsg());
        resp.getWriter().print(info.isFlag());
    }

}
