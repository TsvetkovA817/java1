package pkg1;


public class Calculator {

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }


    public static double squareRootExtraction(double num) {
            if(num < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number");
            }
            return Math.sqrt(num);
    }


    // сумма покупки со скидкой
    public static double calculateDiscount(double purchaseAmount, int discountAmount) {
        double result;
        int maxPercent=100;
        if(purchaseAmount>=0 && discountAmount>=0 && discountAmount<maxPercent) {
            result = purchaseAmount - (purchaseAmount * discountAmount / 100);
        }
        else {
            throw new ArithmeticException("Invalid operand value");
        }
        result=Math.ceil(result * 100) / 100;
        return result;
    }
}
