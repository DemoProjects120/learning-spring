package com.rootnext.spring.app.models.repositories;

import com.rootnext.spring.app.models.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sanjoy on 7/6/15.
 */

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
