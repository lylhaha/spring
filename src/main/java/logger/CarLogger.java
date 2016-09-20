package logger;

/**
 * aop
 * Created by user on 2016/9/1.
 */
public class CarLogger {
    public void beforRun(){
        System.out.println("car is going ro run");
    }
    public void afterRun(){
        System.out.println("car is running");
    }
}
