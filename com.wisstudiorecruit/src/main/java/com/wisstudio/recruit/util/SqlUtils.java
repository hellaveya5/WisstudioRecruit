package com.wisstudio.recruit.util;

import java.util.List;

/**
 * @author 98333
 */
public interface SqlUtils {
    /**
     *  查询操作
     * @param sql   执行的语句
     * @param clazz 返回类型字节码
     * @param args  问号参数
     * @param <T> datatype
     * @return List <T>
     */
    <T> List <T> query (String sql,Class<T> clazz, Object...args);

    /**
     * 更新操作
     * @param sql   执行的语句
     * @param args 问号参数列表
     * @return 更新的行数
     */
     Integer update(String sql, Object...args);

    /**
     *  查询操作 没有?
     * @param sql 执行的语句
     * @param clazz 返回类型字节码
     * @param <T> datatype
     * @return List <T>
     */
     <T> List <T> query (String sql,Class<T> clazz);
}
