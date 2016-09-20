package dao;


import javax.sql.DataSource;



import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by user on 2016/9/19.
 */
public class HelloDao {
    private DataSource dataSource;
    private PlatformTransactionManager  transactionManager;
    //通过注入依赖来完成管理

}
