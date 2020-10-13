package com.zixue.demo.util.thread;

import io.netty.util.internal.InternalThreadLocalMap;
import org.springframework.transaction.reactive.TransactionSynchronizationManager;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedDemo {
    TransactionSynchronizationManager transactionSynchronizationManager=null;


    void  test(){
        ThreadLocal local=null;

        InternalThreadLocalMap localMap;

        ReentrantLock reentrantLock=new ReentrantLock();


        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

    }
}

class A extends WeakReference {

    public A(Object referent) {
        super(referent);
    }
}
