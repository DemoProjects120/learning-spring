package com.rootnext.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by sanjoy on 7/6/15.
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class Application {

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter messagePrinter = applicationContext.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
    }
}
