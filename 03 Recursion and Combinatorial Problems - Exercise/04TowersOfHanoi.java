import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class TowersOfHanoi {
    private static ArrayDeque<Integer> source = new ArrayDeque<>();
    private static ArrayDeque<Integer> destination = new ArrayDeque<>();
    private static ArrayDeque<Integer> spare = new ArrayDeque<>();
    private static int step=0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfDisks = Integer.parseInt(reader.readLine());
        for (int i = numberOfDisks; i > 0; i--) {
            source.push(i);
        }
        print(step);
        move(numberOfDisks, source, destination, spare);
    }

    private static void move(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if(disk==1){
            destination.push(source.pop());
            step++;
            print(step);
        } else {
            move(disk-1, source, spare, destination);
            move(1, source, destination, spare);
            move(disk-1, spare, destination, source);
        }
    }

    private static void print(int step){
        StringBuilder stringBuilder = new StringBuilder();
        if(step > 0) {
            stringBuilder.append("Step #").append(step).append(": Moved disk").append(System.lineSeparator());
        }

        stringBuilder.append("Source: ").append(printRod(source)).append(System.lineSeparator());
        stringBuilder.append("Destination: ").append(printRod(destination)).append(System.lineSeparator());
        stringBuilder.append("Spare: ").append(printRod(spare)).append(System.lineSeparator());
        System.out.println(stringBuilder);
    }

    private static String printRod(ArrayDeque<Integer> stack) {
        return stack.size() == 0 ?
                "" :
                stack.stream().
                        sorted(Comparator.reverseOrder()).
                        map(String::valueOf).collect(Collectors.joining(", "));
    }
}
