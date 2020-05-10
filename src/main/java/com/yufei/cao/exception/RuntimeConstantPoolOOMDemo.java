package com.yufei.cao.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池出现异常demo
 *
 * @author YFC
 * @create 2020-03-14 上午 7:46
 */
public class RuntimeConstantPoolOOMDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }


    }

}
