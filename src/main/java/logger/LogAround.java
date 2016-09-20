package logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interception around 通知 在JoinPoint前后执行
 * Created by user on 2016/9/13.
 */
public class LogAround implements MethodInterceptor {
    private Logger logger=Logger.getLogger(this.getClass().getName());

    /**
     * getArguments()；获取参数
     * @param methodInvocation 可以获取方法的名称
     *                         procceed():执行被调用的方法
     * @return 返回被调用的方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        logger.log(Level.INFO,methodInvocation.getArguments()[0]+"开始审查元素。。。");
        try {
            Object result=methodInvocation.proceed();//返回值即是被调用的方法的返回值
            return  result;
        }finally {
            logger.log(Level.INFO,methodInvocation.getArguments()[0]+"审查结束。。。。");
        }


    }
}
