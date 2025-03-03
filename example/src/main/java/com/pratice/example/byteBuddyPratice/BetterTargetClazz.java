package com.pratice.example.byteBuddyPratice;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

//import java.lang.reflect.Method;

@Slf4j
public class BetterTargetClazz {
    // 被这个注解标注的方法会被ByteBuddy视为委托的拦截方法
    @RuntimeType
    public Object intercept(@AllArguments Object[] allArguments,
                            @Origin Method method, @SuperCall Callable<?> callable) {
        Object ret = null;
        try {
            log.info("Enhance method:{} start.", method.getName());
            ret = callable.call();
            log.info("Enhance method:{} end.", method.getName());
        }catch (Exception e){
            log.error("Method:{} execute error", method.getName(), e);
        }
        // intercept any method of any signature
        return ret;
    }

}
