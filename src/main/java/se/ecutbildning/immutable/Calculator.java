package se.ecutbildning.immutable;

public final class Calculator {
    private final double number;
    private final String calc;

    private Calculator(double number){
        this.number = number;
        this.calc = String.valueOf(number);
    }

    private Calculator(double number, String calc){
        this.number = number;
        this.calc = calc;
    }
    public static Calculator of(double number){
        return new Calculator(number);
    }
    public Calculator add(double number){
     return new Calculator(this.number + number, this.calc + " + " + number);
    }
    public Calculator minus(double number){
        return new Calculator(this.number - number, this.calc + " - " + number);
    }
    public Calculator multiply(double number){
        return new Calculator(this.number * number, this.calc + " * " + number);
    }
    public Calculator divide(double number){
        if(number == 0 || this.number == 0){
            return new Calculator(0, this.calc + " / " + number);
        }
        return new Calculator(this.number / number, this.calc + " / " + number);
    }

    public String getResult(){
        return  this.calc + " = " + number;
    }

}
