package dao;


import javax.sql.DataSource;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by user on 2016/9/19.
 * 事务处理
 */
public class HelloDao {
    private DataSource dataSource;
    private PlatformTransactionManager transactionManager;

    //通过注入依赖来完成管理，xml
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 编程式事务处理
     * 推荐使用create()
     * execute；执行事务
     * TransactionCallback->doInTransaction:进行各种数据库操作
     * 成功：commit
     * 失败:rollbacOnException()；事务回滚
     */
    //进行事务处理
    public int create(String msg) {
        //TransactionTemplate:已编程的方式实现事务控制，无状态且线程安全,需PlatformTransactinManager
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

        Object result = transactionTemplate.execute(
                new TransactionCallback() {
                    @Override
                    public Object doInTransaction(TransactionStatus transactionStatus) {
                        //TODO:执行新增的操作，向数据库新增一笔记录

                        return null;
                    }
                });
        return 1;

    }

    /**
     *doInTransactionWithoutResult:没有返回值
     */
    public void createNO(String msg){
        TransactionTemplate transactionTemplate=new TransactionTemplate(transactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
                jdbcTemplate.update("");//TODO:执行数据库操作
            }
        });

    }
    /**
     * DefaultTransactionDefinition：预定义
     * @param msg
     * @return
     */
    //自己进行rollback commit
    public int createSelf(String msg) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);//声明事务开始
        try {
            //使用JdbcTemplate操作
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update("");//TODO:数据库caoz
        }catch (DataAccessException ex){
            //也可以status.setRollBackOnly();
            transactionManager.rollback(status);
            throw ex;
        }finally {
            transactionManager.commit(status);
        }
        return 1;


    }


}
