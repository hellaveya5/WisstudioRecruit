package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisstudio.recruit.po.User;
import com.wisstudio.recruit.util.BeanUtils;
import com.wisstudio.recruit.util.Impl.BeanUtilsImpl;
import com.wisstudio.recruit.util.Impl.SqlUtilsimpl;
import com.wisstudio.recruit.util.JDBCUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 98333
 */

public class Test {
    JDBCUtils jdbcUtils = new JDBCUtils();
    SqlUtilsimpl beanUtilsimpl = null;


    {
        try {
            beanUtilsimpl = new SqlUtilsimpl(jdbcUtils.getCon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

@org.junit.Test
    public void test01() {
        int id = 1;
        String sql = "select * from tab_user where id = ?";
    SqlUtilsimpl sqlUtilsimpl = null;
    try {
        sqlUtilsimpl = new SqlUtilsimpl(jdbcUtils.getCon());
        List<User> query = sqlUtilsimpl.query(sql, User.class, id);
        System.out.println(query);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    @org.junit.Test
    public void test02(){
        Integer id = 1;
        Object obj=id;
            String sql = "delete from tab_user where "+obj.toString()+" = ?";
            int i=beanUtilsimpl.update(sql,obj.toString());
    }
    @org.junit.Test
    public void test03(){
        Map<String, String[]> map = new HashMap<>();
        String[] strArray={"1","2","3"};
        map.put("name",strArray);
        map.put("password",strArray);
        BeanUtilsImpl beanUtils = new BeanUtilsImpl();
        User populate = beanUtils.populate(User.class, map);
        ObjectMapper mapper = new ObjectMapper();
        String str=null;
        try {
            str=mapper.writeValueAsString(populate);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}