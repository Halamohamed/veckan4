package se.ecutbildning.immutable;

public class Calc {
    public static void main(String[] args) {
        Calculator result = Calculator.of(5)
                .divide(2)
                .multiply(3)
                .minus(7);
        System.out.println(result.getResult());
    }
}
