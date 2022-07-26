import java.util.Arrays;
import java.util.Scanner;

public class PermutationsWithRepetition02 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] elements = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(elements);

        permuteRep(elements, 0, elements.length-1);
    }

    static void permuteRep(int[] arr, int start, int end) {
        print(arr);

        for (int left = end - 1; left >= start; left--) {
            for (int right = left + 1; right <= end; right++) {
                if (arr[left] != arr[right]) {
                    swap(arr, left, right);
                    permuteRep(arr, left + 1, end);
                }
                int firstElement = arr[left];
                for (int i = left; i <= end - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[end] = firstElement;
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static void print(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
