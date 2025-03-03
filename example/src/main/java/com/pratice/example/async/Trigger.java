package com.pratice.example.async;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Trigger {
    @Autowired
    private Caller caller;

    @PostConstruct
    public void trigger(){
        caller.call();

        caller.doAsync();
    }
}
