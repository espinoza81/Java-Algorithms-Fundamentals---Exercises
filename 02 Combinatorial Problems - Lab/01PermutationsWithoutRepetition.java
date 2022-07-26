import java.util.Scanner;

public class PermutationsWithoutRepetition {
    private static String[] elements = null;
    private static String[] permute = null;
    private static boolean[] used = null;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        elements = console.nextLine().split("\\s+");
        used = new boolean[elements.length];
        permute = new String[elements.length];

        permute(0);
    }

    private static void permute(int index) {
        if(index >= elements.length){
            print();
        }

        for(int i=0; i < elements.length; i++){
            if(!used[i]){
                used[i] = true;
                permute[index] = elements[i];
                permute(index+1);
                used[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", permute));
    }
}
