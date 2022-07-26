import java.util.Map;
import java.util.TreeMap;

public class QueensPuzzle {
    private static char[][] matrix = null;
    private static final Map<Integer, Integer> queenPositions = new TreeMap<>();

    public static void main(String[] args) {
        fillMatrix();
        putQueen(0);
    }

    private static void putQueen(int row) {
        if(row==8){
           printMatrix(); 
        } else {
            for(int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    setQueen(row,col);
                    putQueen(row+1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static boolean canPlaceQueen(int row, int col) {
        if(queenPositions.containsValue(col)) return false;
        if(queenPositions.entrySet().stream().anyMatch(s -> s.getKey() - s.getValue() == row - col)) return false;
        return queenPositions.entrySet().stream().noneMatch(s -> s.getKey() + s.getValue() == row + col);
    }

    private static void removeQueen(int row, int col) {
        matrix[row][col] = '-';
        queenPositions.remove(row);
    }

    private static void setQueen(int row, int col) {
        matrix[row][col] = '*';
        queenPositions.put(row, col);
    }

    private static void printMatrix() {
            StringBuilder sb = new StringBuilder();

            for (char[] chars : matrix) {
                for (char aChar : chars) {
                    sb.append(aChar).append(" ");
                }
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
    }

    private static void fillMatrix() {
        matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = '-';
            }
        }
    }
}
