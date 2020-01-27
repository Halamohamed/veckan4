package se.ecutbildning.threadLessonDemo.chaos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Chaos {
    private int count = 0;

    public static void main(String[] args) {
        Chaos chaos = new Chaos();
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            for (int i=0; i<20; i++){
               service.submit(chaos::incrementAndPrint);

            }
        }finally {
            if(service != null){
                service.shutdown();
            }
        }

    }



    private void incrementAndPrint(){
        synchronized (this){
            System.out.println(count++);
        }

    }
}
