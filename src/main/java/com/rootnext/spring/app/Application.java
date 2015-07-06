package com.rootnext.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sanjoy on 7/6/15.
 */
public class Application {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContex.xml");
        MessagePrinter messagePrinter = (MessagePrinter)applicationContext.getBean("messagePrinter");
        messagePrinter.printMessage();
    }
}
