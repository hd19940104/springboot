 package com.zixue.config;
 
 import java.io.PrintStream;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import org.apache.log4j.Logger;
 import org.springframework.scheduling.annotation.Scheduled;
 import org.springframework.stereotype.Component;
 
 @Component
 public class ScheduledTasks
 {
   private static Logger logger = Logger.getLogger(ScheduledTasks.class);
   private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
 
   @Scheduled(fixedRate=300000L)
   public void reportCurrentTime() { logger.info("---------------------现在时间：" + dateFormat.format(new Date()));
     System.out.println("-----------------------现在时间：" + dateFormat.format(new Date()));
   }
 }

