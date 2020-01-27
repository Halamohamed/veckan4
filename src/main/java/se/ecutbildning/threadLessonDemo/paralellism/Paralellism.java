package se.ecutbildning.threadLessonDemo.paralellism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paralellism {
    public static void main(String[] args) {
        print("Hello");
        List<String> messages = new ArrayList<>(Arrays.asList("Erik","Cai","Jonathan","Feras","John","Loffe"," Cleas","Hala","Peter","Khalifa","Cheng"));

        messages.stream()
                .map(s ->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return new StringBuilder(s).reverse().toString();
                })
                .parallel()
                .forEach(Paralellism::print);
    }
    public static void print(String message){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " "+message);
    }
}
