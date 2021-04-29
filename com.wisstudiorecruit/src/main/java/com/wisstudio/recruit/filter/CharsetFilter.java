package com.wisstudio.recruit.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Author:98333
 * @Date:2021/4/29
 * @Description:${PACKAGE_NAME}
 */
@WebFilter(filterName = "CharsetFilter",
        urlPatterns = "/*",
        initParams = {
            @WebInitParam(name = "charset", value = "utf-8")
        }
)
public class CharsetFilter implements Filter {
    private String charset;
    private String filterName;
    @Override
    public void destroy() {
        System.out.println("Filter is off");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 给数据设置编码格式
        resp.setCharacterEncoding(charset);
        req.setCharacterEncoding(charset);
        resp.setContentType("text/html");
        System.out.println("CharsetFilter work");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        charset = config.getInitParameter("charset");
        filterName = config.getFilterName();
        System.out.println("过滤器名称：" + filterName);
        System.out.println("字符集编码：" + charset);
    }

}
