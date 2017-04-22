package com.syl.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shenyunlong on 2017/4/22.
 */
public class JavaScriptModuleRegistry {

    public <T extends JavaScriptModule> T getJavaScriptModule(Class<T> moduleInterface) {
        JavaScriptModule proxy = (JavaScriptModule) Proxy.newProxyInstance(
                moduleInterface.getClassLoader(),
                new Class[]{moduleInterface},
                new JavaScriptModuleInvocationHandler());
        return (T) proxy;
    }

    private static class JavaScriptModuleInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //当proxy对象的方法被调用时，invoke被调用
            System.out.print("Hi " + method.getName() + " [");
            for (Object obj : args) {
                System.out.print(obj);
            }
            System.out.println("]");
            return null;
        }
    }
}
