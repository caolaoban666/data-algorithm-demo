package com.yufei.cao.exception;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存出现OOM异常
 *
 * @author YFC
 * @create 2020-03-14 上午 8:19
 */
public class DirectMemoryOOMDemo {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
