package com.wisstudio.recruit.controller;

import com.wisstudio.recruit.result.ResultInfo;
import com.wisstudio.recruit.util.MailUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author 98333
 */
@WebServlet(urlPatterns = "/toSendEmail")
public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();
        String emailStandard="^[A-Za-z0-9]+([_.][A-Za-z0-9]+)*@([A-Za-z0-9\\-]+\\.)+[A-Za-z]{2,6}$";
        String emailAddr = req.getParameter("email");
        String randomCode = MailUtils.generateRandomCode(6);
        resp.setContentType("text/html;charset=utf-8");
        if(emailAddr.matches(emailStandard)){
            info.setFlag(true);
            try {
                MailUtils.sendMail(emailAddr,randomCode);
                resp.getWriter().write(randomCode);
                Logger.getGlobal().info("邮箱发送成功");
            } catch (Exception e) {
                info.setMsg("邮箱发送失败");
                resp.getWriter().write(info.getMsg());
                Logger.getGlobal().info("邮箱发送失败");
                e.printStackTrace();
            }

        }else {
            info.setMsg("邮箱发送失败");
            resp.getWriter().write(info.getMsg());
            Logger.getGlobal().info("邮箱发送失败");
        }





    }
}
