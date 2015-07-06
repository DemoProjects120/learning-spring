package com.rootnext.spring.app;

import com.rootnext.spring.app.interfaces.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sanjoy on 7/6/15.
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService(){
        return new MessageService() {
            @Override
            public String getMessage() {
                return "Hello World";
            }
        };
    }

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter messagePrinter = applicationContext.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
    }
}
