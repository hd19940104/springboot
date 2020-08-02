package com.zixue.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//Seconds Minutes Hours DayofMonth Month DayofWeek Year或
//每隔5秒执行一次：*/5 * * * * ?
//每隔1分钟执行一次：0 */1 * * * ?
//每天23点执行一次：0 0 23 * * ?
//每天凌晨1点执行一次：0 0 1 * * ?
//每月1号凌晨1点执行一次：0 0 1 1 * ?
//每月最后一天23点执行一次：0 0 23 L * ?
//每周星期天凌晨1点实行一次：0 0 1 ? * L
//在26分、29分、33分执行一次：0 26,29,33 * * * ?
//每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?
@Component
public class ScheduledTasks {
	@Scheduled(fixedRate = 1000*60*60) // 采用间隔调度，每小时秒执行一次
	public void runJobA() { // 定义一个要执行的任务
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(
				"【*** MyTaskA - 间隔调度 ***】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}

	@Scheduled(cron = "0 26,29,33 * * * ?") //在26分、29分、33分执行一次
	public void runJobB() {
		System.err.println(
				"【*** MyTaskB - 间隔调度 ***】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}
}
