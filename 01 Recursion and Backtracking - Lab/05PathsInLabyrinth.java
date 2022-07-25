import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathsInLabyrinth {
    private static int row;
    private static int col;
    private static final List<String> path = new ArrayList<>();
    private static String[][] matrix = null;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        row = Integer.parseInt(console.nextLine());
        col = Integer.parseInt(console.nextLine());


        fillMatrix(console);

        mark(0, 0);
        findPath(0, -1, "L");
        findPath(-1, 0, "U");
        findPath(0, 1, "R");
        findPath(1, 0, "D");
    }

    private static void findPath(int row, int col, String direction) {

        if (!inTheMatrix(row, col)) return;

            path.add(direction);


        if (isExit(row, col)) {

            path.forEach(System.out::print);
            System.out.println();

        } else if(isFree(row, col) && !isMarked(row, col)){

            mark(row, col);
            findPath(row-1, col, "U");
            findPath(row, col+1, "R");
            findPath(row+1, col, "D");
            findPath(row, col-1, "L");
            unMark(row, col);
        }

        path.remove(path.size()-1);
    }

    private static boolean isFree(int rowHero, int colHero) {
        return !matrix[rowHero][colHero].equals("*");
    }

    private static boolean isMarked(int rowHero, int colHero) {
        return matrix[rowHero][colHero].equals("V");
    }

    private static boolean isExit(int rowHero, int colHero) {
        return matrix[rowHero][colHero].contains("e");
    }

    private static void mark(int rowHero, int colHero) {
        matrix[rowHero][colHero] = "V";
    }

    private static void unMark(int rowHero, int colHero) {
        matrix[rowHero][colHero] = "-";
    }

    private static void fillMatrix(Scanner console) {
        matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = console.nextLine().split("");
        }
    }

    public static boolean inTheMatrix(int rowHero, int colHero) {
        return rowHero >= 0 && rowHero < row && colHero >= 0 && colHero < col;
    }
}
