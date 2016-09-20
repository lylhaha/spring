import dao.impl.TimeBookInterface;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user on 2016/9/8.
 */
public class TimeBook implements TimeBookInterface{
    private Logger logger=Logger.getLogger(this.getClass().getName());

    public void doAuditing(String name){
        System.out.println("AOP 动态代理!"+name);
    }
}
