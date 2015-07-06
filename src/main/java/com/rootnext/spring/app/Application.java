package com.rootnext.spring.app;

import com.rootnext.spring.app.models.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by sanjoy on 7/6/15.
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan

public class Application {

    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_demo_app");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        return dataSource;
    }
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource() );
    }
//    @Bean
//    public EmployeeDao getEmployeeDao(){
//        EmployeeDao employeeDao = new EmployeeDao();
//        employeeDao.setJdbcTemplate(getJdbcTemplate());
//        return employeeDao;
//    }

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);

        EmployeeDao employeeDao = applicationContext.getBean(EmployeeDao.class);
        System.out.println(employeeDao.getAllEmployees());
        System.out.println(employeeDao.employeeList());

    }
}
