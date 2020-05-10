package com.yufei.cao.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YFC
 * @create 2020-03-13 下午 9:43
 */
public class OutOfMemeoryDemo {

    // 堆内存异常示例

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
