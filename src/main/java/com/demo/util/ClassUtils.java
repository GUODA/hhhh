package com.demo.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

/**
 * Created by Lenovo on 2015/4/4.
 */
public class ClassUtils {
    /**
     * @param clazz
     * @param propertyName
     * @return
     */
    public static Class<?> getPropertyType(Class<?> clazz, String propertyName) {
        try {
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, clazz);
            return pd.getPropertyType();
        } catch (IntrospectionException e) {
            e.printStackTrace();
            throw new RuntimeException("class util exception" + e.getMessage());
        }
    }

}
