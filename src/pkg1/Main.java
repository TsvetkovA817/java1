package pkg1;


public class Main {
    public static void main(String[] args) {

        int t1= Calculator.calculation(1,2,'+');   //3

        double t2= Calculator.calculateDiscount(10,10);   //9

        pkg1.CalculatorTest.calculateDiscountTest();

        System.out.println(String.format("Результат1: " + t1));
        System.out.println(String.format("Результат2: " + t2));

    }
}
