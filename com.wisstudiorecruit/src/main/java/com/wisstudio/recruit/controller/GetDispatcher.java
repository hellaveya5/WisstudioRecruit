package com.wisstudio.recruit.controller;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import com.sun.deploy.net.HttpResponse;
import com.wisstudio.recruit.vo.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @Author:98333
 * @Date:2021/4/29
 * @Description: controller's dispatcher of getMapping
 * @instance  controller 实例
 * @method controller方法
 * @parameterNames 方法参数
 * @parameterClasses 方法参数类型
 */
public class GetDispatcher {
    Object instance ;
    Method method;
    String[] parameterNames;
    Class<?>[] parameterClasses;

    /**
     * 动态调用 Controller中的方法
     * @param req 分发的请求
     * @param resp 分发的回应
     * @return 返回 数据和链接
     */
    public ModelAndView invoke(HttpServletRequest req, HttpServletResponse resp){
        ModelAndView  modelAndView=null;
        Object[] arguments = new Object[parameterClasses.length];
        for(int i = 0 ;i < parameterClasses.length ; i++){
            String parameterName  =parameterNames[i];
            Class<?> parameterClass = parameterClasses[i];
            if(parameterClass == HttpServletRequest.class){
                arguments[i] = req;
            }else if(parameterClass == HttpResponse.class){
                arguments[i] = resp;
            }else if(parameterClass ==HttpSession.class){
                arguments[i] =req.getSession();
            }else if(parameterClass == int.class){
                arguments[i] = Integer.valueOf(getOrDefault(req, parameterName,"0"));
            }else if(parameterClass ==Long.class){
                arguments[i] = Long.valueOf(getOrDefault(req,parameterName,"0"));
            }else if(parameterClass ==boolean.class){
                arguments[i] = Boolean.valueOf(getOrDefault(req, parameterName ,"false"));
            }else if(parameterClass == String.class){
                arguments[i] = getOrDefault(req, parameterName,"");
            }else {
                throw new RuntimeException("Missing handler for type: "+parameterClass);
            }
        }
        try {
            modelAndView=(ModelAndView) this.method.invoke(this.instance ,arguments);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    private String getOrDefault(HttpServletRequest req, String name, String defaultValue) {
        String s = req.getParameter(name);
        return s== null ? defaultValue : s ;
    }

}
