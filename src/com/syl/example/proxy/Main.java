package com.syl.example.proxy;

/**
 * Dynamic Proxy Example
 * <p>
 * 测试代码参考React Native中Java call JS Module实现
 * <p>
 * Created by shenyunlong on 2017/4/22.
 */
public class Main {

    public static void main(String[] args) {
        JavaScriptModuleRegistry registry = new JavaScriptModuleRegistry();
        AppRegistry module = registry.getJavaScriptModule(AppRegistry.class);
        module.runApplication("appKeyArg");
    }
}
