package logger;

import org.springframework.aop.MethodBeforeAdvice;


import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Before 通知 只在JoinPoint 前执行
 * Created by user on 2016/9/13.
 */
public class LogBefore implements MethodBeforeAdvice{
    private Logger logger=Logger.getLogger(this.getClass().getName());
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        logger.log(Level.INFO,objects[0]+"开始审核。。。。。");

    }
}
