import java.util.Scanner;

public class BasicCalculator {

    // Addition
        static double add(double a, double b) {
        return a + b;
        }
    // Subtraction
        static double subtract(double a, double b) {
        return a - b;
        }
    // Multiplication
        static double multiply(double a, double b) {
        return a * b;
        }
    // Division
        static double divide(double a, double b) {
        return a / b;
        }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("BASIC CALCULATOR");

    // Take input from user 
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("\nChoose an operation:");
        System.out.println("+  Addition");
        System.out.println("-  Subtraction");
        System.out.println("*  Multiplication");
        System.out.println("/  Division");

        System.out.print("Enter operation: ");
        char operation = sc.next().charAt(0);

        double result;

    // Perform operation using switch
        switch (operation) {

            case '+':
                result = add(num1, num2);
                System.out.println("Result = " + result);
                break;

            case '-':
                result = subtract(num1, num2);
                System.out.println("Result = " + result);
                break;

            case '*':
                result = multiply(num1, num2);
                System.out.println("Result = " + result);
                break;

            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                } else {
                    result = divide(num1, num2);
                    System.out.println("Result = " + result);
                }
                break;

            default:
                    System.out.println("Invalid operation!");
        }
        sc.close();
    }
}