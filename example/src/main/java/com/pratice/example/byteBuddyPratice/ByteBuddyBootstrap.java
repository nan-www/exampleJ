package com.pratice.example.byteBuddyPratice;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ByteBuddyBootstrap {

    @PostConstruct
    public void init(){
        Enhance enhance = new Enhance();
        enhance.enhanceTargetClazz();
    }

}
