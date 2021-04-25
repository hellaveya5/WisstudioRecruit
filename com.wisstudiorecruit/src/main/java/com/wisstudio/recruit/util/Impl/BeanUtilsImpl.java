package com.wisstudio.recruit.util.Impl;

import com.wisstudio.Exception.TypeNotEnoughException;
import com.wisstudio.recruit.util.BeanUtils;
import com.wisstudio.recruit.util.ReflectUtils;
import com.wisstudio.recruit.util.SetUtils;

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
        T object =null;
        try {
            //创造实体类对象
            object = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();
            Class<?> aClass = object.getClass();
            //遍历map的键值，查找实例的属性名，给实例属性名注入对应value
            for(String key: map.keySet()){
                for (Field field : fields) {
                    String name = field.getName();
                    Object value =null;
                    if (name.equals(key)) {
                        Field fi = aClass.getDeclaredField(field.getName());
                        fi.setAccessible(true);
                        value = SetUtils.setType(field.getType(), map.get(key)[0]);
                        fi.set(object, value);
                        break;
                    }
                }
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return object;



    }
}