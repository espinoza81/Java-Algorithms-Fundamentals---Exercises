import java.util.Scanner;

public class VariationsWithoutRepetition {
    private static String[] elements = null;
    private static String[] variation = null;
    private static boolean[] used = null;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        elements = console.nextLine().split("\\s+");
        int variationLength = Integer.parseInt(console.nextLine());
        used = new boolean[elements.length];
        variation = new String[variationLength];

        variate(0);
    }

    private static void variate(int index) {
        if(index == variation.length){
            print();
            return;
        }

        for(int i=0; i < elements.length; i++){
            if(!used[i]){
                used[i] = true;
                variation[index] = elements[i];
                variate(index+1);
                used[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", variation));
    }
}
