package com.pratice.example.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

@Component
@Slf4j
public class Caller {

    public void something(){
        System.out.println("^^^^^");
    }

    public void call(){
        this.doAsync();
//        itself.doAsync();
    }

    @Async
    public void doAsync(){
        System.out.println(Thread.currentThread().getName() + "hello!");
    }

    final static Executor executor = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.getSuccessOne();
    }

    void getSuccessOne() {
        AtomicReference<String> result = new AtomicReference<>();
        Semaphore writeSeme = new Semaphore(1);
        CountDownLatch notify = new CountDownLatch(1);
        for (int i = 1; i < 5; i++) {
            int finalI = i;
            CompletableFuture.supplyAsync(() -> doSomething(finalI), executor)
                    .whenComplete((ret, ex) -> {
                        if (ex == null) {
                            if (writeSeme.tryAcquire()) {
                                result.set(ret);
                                notify.countDown();
                            }
                        }
                    })
                    .exceptionally((ex) -> {
                        System.out.println("Error occur." + ex);
                        return null;
                    });
        }
        try {
            if (notify.await(1, TimeUnit.SECONDS)) {
                System.out.println("Success!!! ret: " + result.get());
            }else{
                System.out.println("Time out!!!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String doSomething(int input){
        int time = ThreadLocalRandom.current().nextInt(2000);
        System.out.println(Thread.currentThread().getName() + " sleep " + time);
        try {
            Thread.sleep(time);
            if ((input & 1) == 0){
                throw new RuntimeException("input is: " + input);
            }else{
                return Thread.currentThread().getName() + " " + input;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




}
