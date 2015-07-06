package com.rootnext.spring.app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by sanjoy on 7/6/15.
 */
@Component
public class EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public  EmployeeDao(@Qualifier("dataSource") DataSource dataSource) {
        this.jdbcTemplate =new JdbcTemplate(dataSource);
    }

    public int saveEmployee(Employee e){
        String query = "INSERT INTO employee VALUES(" +
                e.getId() +  ",'" + e.getName() + "'," + e.getSalary() +");";
        return jdbcTemplate.update(query);
    }

    public int updateEmployee(Employee e){
        String query="update employee set " +
        "name='"+e.getName()+"',salary="+e.getSalary()+" where id="+e.getId() + ";";
        return jdbcTemplate.update(query);
    }

    public int deleteEmployee(Employee e){
        String query="delete from employee where id="+e.getId()+";";
        return jdbcTemplate.update(query);
    }
}
