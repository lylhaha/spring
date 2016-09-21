package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;


/**
 * Created by user on 2016/9/21.
 */
public class HelloDAOJdbcTemplate {
    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;
    private String sql;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    //使用JDBCTemplate
    public int create(String msg) {
        DefaultTransactionDefinition df = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(df);//事务开始
        int result = 0;
        try {
            result = jdbcTemplate.update("");//TODO:数据库操作
            jdbcTemplate.update(this.sql);//在xml 中写具体数据库操作

        } catch (Exception ex) {
            transactionManager.rollback(status);
        } finally {
            transactionManager.commit(status);
            return result;
        }


    }
}
