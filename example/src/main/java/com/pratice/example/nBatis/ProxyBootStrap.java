package com.pratice.example.nBatis;

import com.pratice.example.nBatis.dao.FooDao;
import com.pratice.example.nBatis.entity.Foo;
import com.pratice.example.nBatis.proxy.Miwa;
import com.pratice.example.nBatis.proxy.RuntimeMiwa;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.List;

@Component
//@AllArgsConstructor
public class ProxyBootStrap {
    private FooService fooService;
    private FooDao fooDao;

//    @PostConstruct
    public void init(){
        Foo foo = new Foo();
        foo.setName("浜辺美波");
        foo.setAge(18);

        Foo f1 = new Foo();
        f1.setAge(20);
        f1.setName("Yoona");
//        fooDao.insertBatch(List.of(foo, f1));


//        RuntimeMiwa runtimeMiwa = new RuntimeMiwa("浜辺美波さんが好きです。");
//        Miwa miwa = (Miwa) Proxy.newProxyInstance(Miwa.class.getClassLoader(), new Class[]{Miwa.class}, runtimeMiwa);
//        miwa.sayHello();
    }


}
