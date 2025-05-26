import java.time.LocalDateTime;
import java.util.Scanner;

class Answer {
    public static long factorial(int n) {
        if (n < 0) {
           return -1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void printEvenNums(int pL) {
        for (int i = 1; i<=pL; i++){
           if (i % 2==0){
               System.out.println((i));
           }
        }
    }

    public static int sumDigits(int pN) {
        int result = 0;
        int temp = pN;
        while (temp != 0 ){
            result = result +temp % 10;
            temp = temp / 10;
        }
        return result;
    }

    public static int findMaxOfThree(int a, int b, int c) {
        int mx = a;
        if (b > mx) {
            mx = b;
        }
        if (c > mx) {
            mx = c;
        }
    return mx;
    }

}

public class Main {
    public  static void main(String[] args){
        System.out.println(("Старт!"));
        System.out.println(LocalDateTime.now());

        int n=-5;
        if (args.length>0){
            n= Integer.parseInt(args[0]);
        }
        Answer ans = new Answer();
        long itresume_res = ans.factorial(n);
        if (itresume_res<0){
            System.out.println("Факториал отрицательного числа " + n + " не определен");
        }
        System.out.println((itresume_res));
        ans.printEvenNums(10);
        n = 123;
        System.out.println(ans.sumDigits(n));
        System.out.println(ans.findMaxOfThree(3,5,4));
    }
}
