import java.util.Scanner;

public class VariationsWithRepetition {
    private static String[] elements = null;
    private static String[] variations = null;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        elements = console.nextLine().split("\\s+");
        int variationLength = Integer.parseInt(console.nextLine());
        variations = new String[variationLength];
        variations(0);
    }

    private static void variations(int index) {
        if (index == variations.length) {
            print();
        } else {
            for (String element : elements) {
                variations[index] = element;
                variations(index + 1);
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", variations));
    }
}
