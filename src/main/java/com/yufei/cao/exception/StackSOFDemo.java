package com.yufei.cao.exception;

/**
 * @author YFC
 * @create 2020-03-14 上午 6:55
 */
public class StackSOFDemo {

    // 虚拟机栈出现 stackoverflow 异常demo

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        try {
            StackSOFDemo sof = new StackSOFDemo();
            sof.stackLeak();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
