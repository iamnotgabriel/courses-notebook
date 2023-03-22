package com.learn_spring.indepth_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreeterImpl {

    @Autowired
    public final Goodbye  portugueseGoodbye;


    GreeterImpl(Goodbye portugueseGoodbye) {
        this.portugueseGoodbye = portugueseGoodbye;
    }


    public String  greet() {
        return "Hi, you are awesome, " + portugueseGoodbye.say();
    }

}
