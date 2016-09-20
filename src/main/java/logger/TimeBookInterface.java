package logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user on 2016/9/8.
 */
public class TimeBookInterface {
    private Logger logger=Logger.getLogger(this.getClass().getName());
    private TimeBookInterface timeBookInterface;
    //针对接口编程

    public TimeBookInterface(TimeBookInterface timeBookInterface) {
        this.timeBookInterface = timeBookInterface;
    }

    public void doAuditing(String name){
        logger.log(Level.INFO,name+"开始");
        timeBookInterface.doAuditing(name);
        logger.log(Level.INFO,name+"结束");
    }
}
