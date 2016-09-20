package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * 声明式事务
 * Created by user on 2016/9/20.
 */
public class HelloDaoMajor {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    //通过依赖注入
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate=new JdbcTemplate( dataSource);
    }

    //在xml中配置事务处理
    public void create(String msg){
        jdbcTemplate.update("");
    }




}
