import java.util.Scanner;

public class NChooseKCount {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        int k = Integer.parseInt(console.nextLine());
        System.out.println(binom(n, k));
    }

    public static int binom(int n, int k) {
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;
        return binom(n - 1, k - 1) + binom(n - 1, k);
    }
}
