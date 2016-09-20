package logger;

import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user on 2016/9/8.
 * 动态代理:Proxy
 */
public class LogProxy implements InvocationHandler {
    private Logger logger= Logger.getLogger(this.getClass().getName());
    private Object delegate;

    //绑定代理对象
    public Object bind(Object delegate){
        this.delegate=delegate;
        //参数：classLoader类加载器，需要是实现的接口数组，InvocationHandler接口
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(),delegate.getClass().getInterfaces(),this);
    }


    /**
     * 接口编程
     * @param proxy 通常情况下不需要
     * @param method 方法对象的引用，被调用的方法
     * @param args 对象数组，被调用方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        try {
            logger.log(Level.INFO, args[0] + "开始审核数据");
            result = method.invoke(delegate, args);
            logger.log(Level.INFO, args[0] + "结束");
        }catch (Exception e){
            logger.log(Level.INFO,e.toString());
        }
        return result;
    }
}
