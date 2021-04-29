package com.wisstudio.recruit.controller;

import com.wisstudio.recruit.vo.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:98333
 * @Date:2021/4/29
 * @Description:com.wisstudio.recruit.controller
 */

@WebServlet(urlPatterns = "/")
public class DispatcherServlet extends HttpServlet {
    private Map<String , GetDispatcher> getMappings = new HashMap<>();
    private Map<String , GetDispatcher> postMappings = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI().substring(req.getContextPath().length());
        //根据路径查询GetDisPatcher
        GetDispatcher dispatcher = this.getMappings.get(path);
        if(dispatcher == null){
            resp.sendError(404);
            return ;
        }
        ModelAndView mv = dispatcher.invoke(req, resp);
        if(mv == null){
            return ;
        }
        if(mv.getView().startsWith("redirect:")) {
            resp.sendRedirect(mv.getView().substring(9));
            return;
        }
        PrintWriter pw = resp.getWriter();
        pw.write(mv.toString());
        pw.flush();
    }
}
