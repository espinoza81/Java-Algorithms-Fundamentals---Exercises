import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Generating01Vectors {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Integer[] vector = new Integer[Integer.parseInt(console.nextLine())];

        generateVector(vector, 0);
      
        System.out.println();
    }

    private static void generateVector(Integer[] vector, int index) {

        if (index >= vector.length) {
            System.out.println(Arrays.stream(vector).map(String::valueOf).collect(Collectors.joining("")));
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            generateVector(vector, index + 1);
        }
    }
}
