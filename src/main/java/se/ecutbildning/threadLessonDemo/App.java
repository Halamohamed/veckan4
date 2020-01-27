package se.ecutbildning.threadLessonDemo;

public class App {
    public static void main(String[] args) {

        int[] ints = {234,23,-12,79,-2456,343456};
        NumberCruncher cruncher= new NumberCruncher(ints);
        Thread thread = new Thread(cruncher);
        thread.start();

        while (cruncher.getResult() == 0){
            System.out.println(Thread.currentThread().getName() + " is waiting.. (");
        }
        System.out.println(cruncher.getResult());
    }
}
