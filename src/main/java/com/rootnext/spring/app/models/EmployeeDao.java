package com.rootnext.spring.app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjoy on 7/6/15.
 */
class EmployeeRowMapper implements RowMapper<Employee>{
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee e  = new Employee();
        e.setId(rs.getLong(1));
        e.setName(rs.getString(2));
        e.setSalary(rs.getFloat(3));
        return e;
    }
}
@Component
public class EmployeeDao {
    private final JdbcTemplate jdbcTemplate;
    private RowMapper<Employee> employeeRowMapper;

    @Autowired
    public  EmployeeDao(@Qualifier("dataSource") DataSource dataSource) {
        this.jdbcTemplate =new JdbcTemplate(dataSource);
        employeeRowMapper = new EmployeeRowMapper();
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

    public List<Employee> employeeList(){
        return jdbcTemplate.query("SELECT * FROM employee;", employeeRowMapper);
    }

    public List<Employee> getAllEmployees(){
        return jdbcTemplate.query("SELECT * FROM employee;", new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<Employee>();
                while (rs.next()){
                    Employee e  = new Employee();
                    e.setId(rs.getLong(1));
                    e.setName(rs.getString(2));
                    e.setSalary(rs.getFloat(3));
                    list.add(e);
                }
                return list;
            }
        });
    }

    public Employee get(Long id){
        return null;
    }
}
