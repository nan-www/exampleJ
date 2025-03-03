package com.pratice.example.byteBuddyPratice;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;


public class Enhance {
    public void enhanceTargetClazz(){
        try {
            DynamicType.Unloaded<TargetClazz> BuddyBetterClazz = new ByteBuddy()
                    .subclass(TargetClazz.class)
                    .method(ElementMatchers.any())
                    .intercept(MethodDelegation.to(new BetterTargetClazz()))
                    .make();
            DynamicType.Loaded<TargetClazz> load = BuddyBetterClazz.load(getClass().getClassLoader(),
                    ClassLoadingStrategy.Default.WRAPPER);
            load.saveIn(new File("./output"));
            TargetClazz targetClazz = load.getLoaded().getDeclaredConstructor().newInstance();
            targetClazz.speak();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
