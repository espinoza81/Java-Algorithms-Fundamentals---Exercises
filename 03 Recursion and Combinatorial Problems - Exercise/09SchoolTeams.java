import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolTeams {
    private static final String[] combinationsGirls = new String[3];
    private static final String[] combinationsBoy = new String[2];
    private static final List<String> allCombinationsGirls = new ArrayList<>();
    private static final List<String> allCombinationsBoys = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> girls = Arrays.stream(console.nextLine().split(",\\s+")).collect(Collectors.toList());
        List<String> boys = Arrays.stream(console.nextLine().split(",\\s+")).collect(Collectors.toList());

        comb(0, 0, girls, combinationsGirls, allCombinationsGirls);
        comb(0, 0, boys, combinationsBoy, allCombinationsBoys);
        allCombinationsGirls.forEach(g -> allCombinationsBoys.forEach(b -> System.out.println(g + ", " + b)));
    }

    public static void comb(int index, int start, List<String> people, String[] combinations, List<String> allCombinations) {
        if (index >= combinations.length) {
            allCombinations.add(print(combinations));
        } else {
            for (int i = start; i < people.size(); i++) {
                combinations[index] = people.get(i);
                comb(index + 1, i + 1, people, combinations, allCombinations);
            }
        }
    }

    private static String print(String[] arr) {
        return String.join(", ", arr);
    }
}
