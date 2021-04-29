package com.wisstudio.recruit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import com.wisstudio.recruit.vo.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;

/**
 *
 * @Author:98333
 * @Date:2021/4/29
 * @Description: controller's dispatcher of postMapping
 * @ObjectMapper JSONValue 仅接受JSON格式的post请求
 */
public class PostDispatcher  {
        Object instance ;
        Method method ;
        Class<?>[] parameterClasses ;
        ObjectMapper objectMapper;

        public ModelAndView invoke(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
            BufferedReader  reader= null;
            Object[] arguments = new Object[parameterClasses.length];
            for(int i = 0 ; i < parameterClasses.length ; i++){
                Class<?> parameterClass = parameterClasses[i];
                if(parameterClass == HttpServletRequest.class){
                    arguments[i] = req;
                }else if(parameterClass == HttpServletResponse.class){
                    arguments[i] = resp;
                }else if(parameterClass == HttpSession.class){
                    arguments[i] = req.getSession();
                }else {
                        reader = req.getReader();
                        arguments[i] =this.objectMapper.readValue(reader, parameterClass);
                }
            }
            return (ModelAndView) this.method.invoke(instance , arguments);
        }
}
