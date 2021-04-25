package com.wisstudio.recruit.util;

import com.wisstudio.Exception.TypeNotEnoughException;

/**
 * @Author:98333
 * @Date:2021/4/26
 * @Description:com.wisstudio.recruit.util
 */
public class SetUtils {
    /**
     *
     * @param clazz 传入的类型
     * @param a
     * @return
     */
    public static Object setType(Class<?> clazz, String a ){
        try{
            if ("class java.lang.Integer".equalsIgnoreCase(clazz.toString())) {

                return Integer.parseInt(a);

            } else if ("class java.lang.String".equalsIgnoreCase(clazz.toString())) {
                return a;
            } else if ("class java.lang.long".equalsIgnoreCase(clazz.toString())){
                return Long.parseLong(a);
            }
        }catch (TypeNotEnoughException e){
            e.printStackTrace();
        }
        return null;
    }
}
