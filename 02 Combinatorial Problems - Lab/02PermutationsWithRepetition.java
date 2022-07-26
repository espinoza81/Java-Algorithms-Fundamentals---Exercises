import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetition {
    private static String[] elements = null;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        elements = console.nextLine().split("\\s+");

        permute(0);
    }

    private static void permute(int index) {
        if (index >= elements.length) {
            print();
        } else {
            permute(index + 1);

            HashSet<String> swapped = new HashSet<>();
            swapped.add(elements[index]);

            for (int i = index + 1; i < elements.length; i++) {
                if (!swapped.contains(elements[i])) {
                    swap(index, i);
                    permute(index + 1);
                    swap(index, i);
                    swapped.add(elements[i]);
                }
            }
        }
    }

    private static void swap(int index, int i) {
        String temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }

    private static void print() {
        System.out.println(String.join(" ", elements));
    }
}
