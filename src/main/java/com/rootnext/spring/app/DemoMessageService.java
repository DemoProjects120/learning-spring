package com.rootnext.spring.app;

import com.rootnext.spring.app.interfaces.MessageService;
import org.springframework.stereotype.Component;

/**
 * Created by sanjoy on 7/6/15.
 */
@Component
public class DemoMessageService implements MessageService{

    @Override
    public String getMessage() {
        return "Hello World !!!";
    }
}
