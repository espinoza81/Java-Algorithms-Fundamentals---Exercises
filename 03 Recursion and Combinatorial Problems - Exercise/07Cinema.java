import java.util.*;
import java.util.stream.Collectors;

public class Cinema {
    private static List<String> elements = null;
    private static final Set<String> takenPlaces = new HashSet<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        elements = Arrays.stream(console.nextLine().split(",\\s+")).collect(Collectors.toList());

        String takenPlace;

        while (!"generate".equals(takenPlace = console.nextLine())){
            String[] attributes = takenPlace.split("\\s+-\\s+");
            String name = attributes[0];
            int seat = Integer.parseInt(attributes[1]);
            swap(elements.indexOf(name), seat-1);
            takenPlaces.add(name);
        }

        permute(0);
    }

    private static void permute(int index) {
        if(index >= elements.size()){
            print();
        } else {
            permute(index + 1);

            for (int i = index + 1; i < elements.size(); i++) {
                if(!takenPlaces.contains(elements.get(i)) && !takenPlaces.contains(elements.get(index))) {
                    swap(index, i);
                    permute(index + 1);
                    swap(index, i);
                }
            }
        }
    }

    private static void swap(int firstIndex, int secondIndex) {
        String temp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, temp);
    }

    private static void print() {
        System.out.println(String.join(" ", elements));
    }
}
