import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NestedLoops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] vector = new Integer[Integer.parseInt(reader.readLine())];

        generateVector(vector, 0);

        System.out.println();
    }

    private static void generateVector(Integer[] vector, int index) {

        if (index >= vector.length) {
            System.out.println(Arrays.stream(vector).map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 1; i <= vector.length; i++) {
            vector[index] = i;
            generateVector(vector, index + 1);
        }
    }
}
