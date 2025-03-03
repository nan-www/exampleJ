package com.pratice.example.nBatis.proxy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
@AllArgsConstructor
public class RuntimeMiwa implements InvocationHandler {

    private String words;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info(words);
        return null;
    }
}
