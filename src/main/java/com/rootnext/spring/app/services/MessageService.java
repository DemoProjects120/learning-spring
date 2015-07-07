package com.rootnext.spring.app.services;

import com.rootnext.spring.app.models.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sanjoy on 7/6/15.
 */
@Component
public class MessageService {
    @Autowired
    EmployeeRepository employeeRepository;

    public String getMessage(){
        return "Hello World !!!??!!!";
    };

    public void showEmployees(){
        System.out.println(employeeRepository.findAll());
    }
}
