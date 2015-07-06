package com.rootnext.spring.app.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Created by sanjoy on 7/6/15.
 */
@Component
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
