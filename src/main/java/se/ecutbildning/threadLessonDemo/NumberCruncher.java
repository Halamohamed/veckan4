package se.ecutbildning.threadLessonDemo;

import java.util.Arrays;

public class NumberCruncher implements Runnable {
    private int[] numbers;
    double result;

    public NumberCruncher(int[] numbers) {
        this.numbers = numbers;

    }

    public double getResult(){
        return result;
    }

    @Override
    public void run() {
       double result = Arrays.stream(numbers)
               .average()
               .orElseThrow(IllegalArgumentException::new);
       this.result= result;
    }
}
