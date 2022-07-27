import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] array = console.nextLine().split("\\s+");

        reverse(array, 0, array.length-1);

        Arrays.stream(array).forEach(s -> System.out.print(s + " "));
    }

    private static void reverse(String[] array, int firstIndex, int lastIndex) {
        if(firstIndex==lastIndex) return;

        String temp = array[firstIndex];
        array[firstIndex] = array[lastIndex];
        array[lastIndex] = temp;

        if(firstIndex + 1 == lastIndex) return;

        reverse(array, firstIndex + 1, lastIndex-1);
    }
}
