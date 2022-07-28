import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CombinationsWithRepetitionEx {
    private static Integer[] vector;
    private static Integer[] temp;
    private static int numberOfElementsToCombine;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        vector = new Integer[Integer.parseInt(reader.readLine())];
        numberOfElementsToCombine = Integer.parseInt(reader.readLine());
        temp = new Integer[numberOfElementsToCombine];

        generateVector(0, 1);

        System.out.println();
    }

    private static void generateVector(int index, int start) {

        if (index >= numberOfElementsToCombine) {
            System.out.println(Arrays.stream(temp).map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        for (int i = start; i <= vector.length; i++) {
            temp[index] = i;
            generateVector(index + 1, i);
        }
    }
}
