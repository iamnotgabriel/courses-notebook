package com.learn_spring.indepth_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreeterImpl {

    @Autowired
    private Goodbye  goodbye;


    public void  greet() {
        
    }

}
