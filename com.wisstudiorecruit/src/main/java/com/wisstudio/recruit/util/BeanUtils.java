package com.wisstudio.recruit.util;

import java.util.List;

/**
 * @author 98333
 */
public interface BeanUtils {
    /**
     *  查询操作
     * @param sql   执行的语句
     * @param clazz 返回类型字节码
     * @param args  问号参数
     * @param <T>
     * @return
     */
    <T> List <T> query (String sql,Class<T> clazz, Object...args);

    /**
     * 更新操作
     * @param sql
     * @param clazz 返回List泛型字节码对象
     * @param args 问号参数列表
     * @param <T>
     * @return 更新的行数
     */
    <T> Integer update(String sql,Class<T> clazz, Object...args);
}
