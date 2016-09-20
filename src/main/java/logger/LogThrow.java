package logger;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user on 2016/9/14.
 */
public class LogThrow implements ThrowsAdvice {
    private Logger logger=Logger.getLogger(this.getClass().getName());
    public  void afterThrowing(Method method, Object[] objects, Object object, Throwable throwable){
        logger.log(Level.INFO,objects[0]+"审核数据有异常抛出。。。。");
    }
}
