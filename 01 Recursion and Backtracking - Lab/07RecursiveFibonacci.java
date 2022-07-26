import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RecursiveFibonacci {

    public static Map<Integer, Long> fibonacci = new TreeMap<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        System.out.println(fibonacci(number));
    }

    static long fibonacci(int n) {

        if (n <= 1) {
            return 1;
        }

        if (fibonacci.containsKey(n)) {
            return fibonacci.get(n);
        }

        long fibValue = fibonacci(n - 1) + fibonacci(n - 2);
        fibonacci.put(n, fibValue);
        return fibValue;
    }
}
