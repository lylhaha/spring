import dao.FinanceImplements;
import dao.impl.FinanceInterface;
import dao.impl.TimeBookInterface;
import logger.LogProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by user on 2016/9/8.
 */
public class Test {
    public static void main(String[] args) {
//        LogProxy logProxy=new LogProxy();
//        TimeBookInterface timeBookInterface= (TimeBookInterface) logProxy.bind(new TimeBook());
//        timeBookInterface.doAuditing("张三");
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TimeBookInterface timeBookInterface = (TimeBookInterface) context.getBean("logAroundProxy");
        timeBookInterface.doAuditing("logAround---");
        // FinanceInterface financeInterface= (FinanceInterface) context.getBean("logAroundProxy1");
        //financeInterface.doCheck("finance---");
//        TimeBookInterface timeBookInterface1= (TimeBookInterface) context.getBean("logBeforeProxy");
//        timeBookInterface1.doAuditing("Before--");
//        TimeBookInterface timeBookInterface= (TimeBookInterface) context.getBean("logAfterProxy");
//        timeBookInterface.doAuditing("After---------");


    }
}
