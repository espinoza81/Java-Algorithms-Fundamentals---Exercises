import java.util.Scanner;

public class PermutationsWithoutRepetitionSwap {
    private static String[] elements = null;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        elements = console.nextLine().split("\\s+");

        permute(0);
    }

    private static void permute(int index) {
        if(index >= elements.length){
            print();
        } else {
            permute(index + 1);

            for (int i = index + 1; i < elements.length; i++) {
                swap(index, i);
                permute(index + 1);
                swap(index, i);

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
