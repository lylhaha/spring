package logger;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * After Returning通知只在JoinPoint的后面执行
 * Created by user on 2016/9/14.
 */
public class LogAfter implements AfterReturningAdvice{
    private Logger logger=Logger.getLogger(this.getClass().getName());
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        logger.log(Level.INFO,objects[0]+"审核数据完成。。。。");

    }
}
