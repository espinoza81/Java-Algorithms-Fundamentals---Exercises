import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        long factorial = factorialFunc(number);

        System.out.println(factorial);
    }

    private static long factorialFunc(int number) {

        if(number < 2) return 1;

        return number * factorialFunc(number-1);
    }
}
