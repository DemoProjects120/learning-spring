package com.rootnext.spring.app;

import com.rootnext.spring.app.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sanjoy on 7/6/15.
 */
@Component
public class MessagePrinter {

    private final MessageService messageService;

    @Autowired
    public MessagePrinter(MessageService messageService){
        this.messageService = messageService;
    }

    public void printMessage(){
        System.out.println(messageService.getMessage());
    }
}
