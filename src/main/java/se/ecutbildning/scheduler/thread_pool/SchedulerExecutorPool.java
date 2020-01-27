package se.ecutbildning.scheduler.thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SchedulerExecutorPool {
    private static SchedulerExecutorPool INSTANCE;
    static {
        INSTANCE = new SchedulerExecutorPool();
    }
    private final ScheduledExecutorService executorPool;

    private SchedulerExecutorPool(){
        executorPool = Executors.newScheduledThreadPool(2);
    }
    public static SchedulerExecutorPool getInstance(){
        return INSTANCE;
    }
    public ScheduledExecutorService geSchedulerExecutorService(){
        return executorPool;
    }
}
