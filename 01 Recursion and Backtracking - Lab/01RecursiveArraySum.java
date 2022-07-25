import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] array = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum = recursiveSum(array, array.length-1);

        System.out.println(sum);
    }

    private static int recursiveSum(int[] array, int element) {

        if(element < 0) return 0;

        return array[element] + recursiveSum(array, element-1);
    }
}
