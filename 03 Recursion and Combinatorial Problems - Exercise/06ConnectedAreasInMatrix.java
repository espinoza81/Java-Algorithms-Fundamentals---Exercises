import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ConnectedAreasInMatrix {
    private static int row;
    private static int col;
    private static int step;
    private static String[][] matrix = null;
    private static final List<Area> areas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        row = Integer.parseInt(console.nextLine());
        col = Integer.parseInt(console.nextLine());

        fillMatrix(console);

        findUnexpectedArea();

        printMatrix();
    }

    private static void findUnexpectedArea() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("-")) {
                    step = 0;
                    Area area = new Area(row, col);
                    findPath(row, col);
                    area.setSteps(step);
                    areas.add(area);
                }
            }
        }
    }

    private static void findPath(int row, int col) {
        if (!inTheMatrix(row, col) || notTraversable(row, col)) return;

        matrix[row][col] = "V";
        step++;

        findPath(row - 1, col);
        findPath(row, col + 1);
        findPath(row + 1, col);
        findPath(row, col - 1);
    }

    private static boolean notTraversable(int row, int col) {
        return matrix[row][col].equals("*") || matrix[row][col].equals("V");
    }

    private static void fillMatrix(Scanner console) {
        matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = console.nextLine().split("");
        }
    }

    public static boolean inTheMatrix(int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < row && currentCol >= 0 && currentCol < col;
    }

    private static void printMatrix() {
        AtomicInteger number = new AtomicInteger(1);

        String out = "Total areas found: " + areas.size() + System.lineSeparator() +
                areas.stream().
                        sorted(Comparator.comparingInt(Area::getSteps).reversed()).
                        map(s -> "Area #" + number.getAndIncrement() + " at (" + s.getRow() + ", " + s.getCol() + "), size: " + s.getSteps()).
                        collect(Collectors.joining(System.lineSeparator()));

        System.out.println(out);
    }

    static class Area {
        private final int row;
        private final int col;
        private int steps;

        public Area(int row, int col) {
            this.row = row;
            this.col = col;
            this.steps = 1;
        }

        public void setSteps(int steps) {
            this.steps = steps;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getSteps() {
            return steps;
        }
    }
}
