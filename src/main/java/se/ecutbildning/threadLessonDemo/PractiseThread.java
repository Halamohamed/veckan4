package se.ecutbildning.threadLessonDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * skapa en tom arraylist
 * skapa 6 trådar
 * tre ska lägga till
 * två ska ta bort
 * en ska skriva ut size
 * ni behöver trådsäkra
 */
public class PractiseThread {
    static List<String> strings = new ArrayList<>();
    public static void main(String[] args) {
        Runnable adder = PractiseThread::addName;
        Runnable remove = PractiseThread::removeName;
        Runnable printer = PractiseThread::printName;
        ExecutorService executorService= Executors.newCachedThreadPool();

        while (true){
            executorService.submit(adder);
            executorService.submit(adder);
            executorService.submit(adder);

            executorService.submit(remove);
            executorService.submit(remove);
            executorService.submit(printer);
        }
        /*while (true){
            try {
                CyclicBarrier barrier = new CyclicBarrier(6);
            Future<?> result1 = executorService.submit(adder);
            Future<?> result2 =executorService.submit(adder);
            Future<?> result3 =executorService.submit(adder);

            //result1.get();result2.get(); result3.get();

            Future<?> result4 =executorService.submit(remove);
            Future<?> result5 =executorService.submit(remove);
            //result4.get(); result5.get();
            Future<?> result6 =executorService.submit(printer);
            //result6.get();
            barrier.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        /*Thread adder1 = new Thread(adder);
        Thread adder2 = new Thread(adder);
        Thread rem = new Thread(remove);

        new Thread(()-> System.out.println("Hello World")).start();

        new Thread().start();

        new Thread().start();
        new Thread().start();
        new Thread().start();
*/
    }
    public static void addName(){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            strings.add("Hala");

        }

    }
    public static void removeName(){
        strings.remove("Hala");
    }
    public static void printName(){
        System.out.println(strings.size());
    }
}
