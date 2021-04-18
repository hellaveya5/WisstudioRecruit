package com.wisstudio.recruit.util.Impl;

import com.wisstudio.Exception.TypeNotEnoughException;
import com.wisstudio.recruit.util.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author 98333
 */
public class BeanUtilsImpl implements BeanUtils {
    @Override
    public <T> T populate(Class<T> clazz, Map<String, String[]> map) {
        Field[] field = clazz.getDeclaredFields();
        List<String> mapKeys = new ArrayList<>();
        //列名
        List<String> propertyKeys = new ArrayList<>();
        //值名
        List<Object> propertyValues = new ArrayList<>();
        //数据类型字节码对象
        List<Class<?>> propertyClass = new ArrayList<>();
        for (Field fiel : field) {
            propertyClass.add(fiel.getType());
            propertyKeys.add(fiel.getName());
        }
        //取值处理不了含有数字类型的情况
        Iterator<String> iter = map.keySet().iterator();
        try {
            while (iter.hasNext()) {
                String key = iter.next();
               /* System.out.println(key);*/
                mapKeys.add(key);
                String a = map.get(key)[0];

                    for(int j=0;j<propertyKeys.size();j++){
                        if(propertyKeys.get(j).equalsIgnoreCase(key)){
                            if ("class java.lang.Integer".equalsIgnoreCase(propertyClass.get(j).toString())) {
                                Integer b = Integer.parseInt(a);
                         /*       System.out.println("Int");*/
                                propertyValues.add(b);
                                break;
                            } else if ("class java.lang.String".equalsIgnoreCase(propertyClass.get(j).toString())) {
                                propertyValues.add(a);
                               /* System.out.println("stirng");*/
                                break;
                            } else {
                                throw new TypeNotEnoughException();
                            }
                        }
                    }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        T object = null;
        try {
            object = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < mapKeys.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("set").append(mapKeys.get(i).substring(0, 1).toUpperCase()).append(mapKeys.get(i).substring(1));
                Method method = null;
            for(int j=0;j<propertyKeys.size();j++){
                if (propertyKeys.get(j).equals(mapKeys.get(i))) {
                    try {
                        /*System.out.println(propertyKeys.get(j));
                        System.out.println(mapKeys.get(i));*/
                        assert object != null;
                        method = object.getClass().getDeclaredMethod(sb.toString(), propertyClass.get(j));
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    //测试用例
                 /*   System.out.println(propertyValues.get(i));
                    System.out.println(mapKeys.get(i));
                    System.out.println(sb.toString());
                    System.out.println(propertyClass.get(j));*/
                    try {
                        assert method != null;
                        method.invoke(object, propertyValues.get(i));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return object;
    }


}
