import java.util.Scanner;

public class CombinationsWithRepetition {
    private static String[] elements = null;
    private static String[] combinations = null;
    private static int k;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        elements = console.nextLine().split("\\s+");
        k = Integer.parseInt(console.nextLine());
        combinations = new String[k];

        comb(0, 0);
    }

    public static void comb(int index, int start) {
        if (index >= k) {
            print(combinations);
        } else {
            for (int i = start; i < elements.length; i++) {
                combinations[index] = elements[i];
                comb(index + 1, i);
            }
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
