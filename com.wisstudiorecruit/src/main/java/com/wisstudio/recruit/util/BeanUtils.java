package com.wisstudio.recruit.util;

import java.util.List;
import java.util.Map;

public interface BeanUtils {
    <T> T populate (Class<T> clazz, Map<String,String[]> map);
}
