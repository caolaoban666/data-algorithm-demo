package com.yufei.cao.exception;

import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.assertj.core.internal.cglib.proxy.MethodInterceptor;

/**
 * @author YFC
 * @create 2020-03-14 上午 7:49
 */
public class MethodAreaOOMDemo {

    public static void main(String[] args) {

        while (true){

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));

            enhancer.create();

        }

    }

    static class OOMObject{

    }


}
