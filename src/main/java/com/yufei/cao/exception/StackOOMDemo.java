package com.yufei.cao.exception;

/**
 * @author YFC
 * @create 2020-03-14 上午 6:58
 */
public class StackOOMDemo {

    private  void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){

        while (true){
            new Thread(() -> dontStop()).start();
        }

    }

    public static void main(String[] args) {
        StackOOMDemo oomDemo = new StackOOMDemo();
        oomDemo.stackLeakByThread();
    }



}
