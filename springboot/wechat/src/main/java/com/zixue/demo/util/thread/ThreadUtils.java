package com.zixue.demo.util.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.*;

/**
 * 线程池创建
 */
public class ThreadUtils {


    private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("this is call");
                return "success";
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);


        new Thread(futureTask).start();
        System.out.println(futureTask.isDone());
        if (!futureTask.isDone()){
            String s = futureTask.get();
            System.out.println(s);
        }



        // 线程⼯⼚，⽤于为线程池中的每条线程命名
//        ThreadFactory namedThreadFactory = new
//                ThreadFactoryBuilder().setNameFormat("stats-pool-%d").build();

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("judge-pool-%d")
                .setUncaughtExceptionHandler((thread, throwable)->
                        logger.error("ThreadPool {} got exception", thread,throwable))
                .build();

        // 创建线程池，使⽤有界阻塞队列防⽌内存溢出
        ExecutorService statsThreadPool = new ThreadPoolExecutor(5, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(100), namedThreadFactory);

        statsThreadPool.submit(futureTask);
    }





}

class Demo2 implements Runnable{

    @Override
    public void run() {

    }
}

class Demo implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }


}
