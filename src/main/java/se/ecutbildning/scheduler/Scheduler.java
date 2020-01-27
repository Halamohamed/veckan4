package se.ecutbildning.scheduler;

import se.ecutbildning.scheduler.thread_pool.SchedulerExecutorPool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    public static void main(String[] args) {
        SchedulerExecutorPool pool = SchedulerExecutorPool.getInstance();
        ScheduledExecutorService service= null;
        try {
            service = pool.geSchedulerExecutorService();
            service.schedule(Scheduler::sayGoodBye, 10, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(Scheduler::sayHello,1,2, TimeUnit.SECONDS);

            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(service != null){
               service.shutdown();
            }
        }
    }


    public static void sayHello(){
        System.out.println("Hello");
    }
    public static void sayGoodBye(){
        System.out.println("GoodBye");
    }
}
