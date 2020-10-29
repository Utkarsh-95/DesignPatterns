package com.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class SingletonClass {

    private static SingletonClass sSoleInstance;

    //private constructor.
    private SingletonClass() {

        //Prevent form the reflection api.
        if (sSoleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonClass getInstance() {//thread safe
//        if (sSoleInstance == null) { //if there is no instance available... create new one
//            sSoleInstance = new SingletonClass();
//        }

        //Double check locking pattern
        if (sSoleInstance == null) { //Check for the first time

            synchronized (SingletonClass.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (sSoleInstance == null) {
                    sSoleInstance = new SingletonClass();
                }
            }
        }

        return sSoleInstance;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

//        Reflection 
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance3 = null;
        try {
            Class<SingletonClass> clazz = SingletonClass.class;
            Constructor<SingletonClass> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance3 = cons.newInstance();
            System.out.println(instance1);
            System.out.println(instance3+"--Reflection");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
//
//        System.out.println("Instance 1 hash:" + instance1.hashCode());
//        System.out.println("Instance 2 hash:" + instance2.hashCode());
//        SingletonClass sc = SingletonClass.getInstance();
//        System.out.println(sc);
//        SingletonClass sc1 = SingletonClass.getInstance();
//        System.out.println(sc1);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonClass instance1 = SingletonClass.getInstance();
                System.out.println("Instance 1 hash:" + instance1.hashCode());
            }
        });

        Thread t2 = new Thread(() -> {
            SingletonClass instance2 = SingletonClass.getInstance();
            System.out.println("Instance 2 hash:" + instance2.hashCode());
        });

        //start both the threads
        t1.start();
        t2.start();
    }
}
