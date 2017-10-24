import java.util.Arrays;
import java.util.stream.IntStream;

public class Matrix {

    private int[][] matrix;
    int rowsCount;
    int columnsCount;

    // did not pass all tests
    public Matrix(String matrixAsString) {
        int numberRows;
        int numberColumns;

        if(matrixAsString.contains("\n")) {
            String[] matrixRows = matrixAsString.split("\n");
            numberRows = matrixRows.length;
            // separated by spaces, but final space missing
            numberColumns = (matrixRows[0].length() + 1)/2;

            int[][] matrix = new int[numberRows][numberColumns];
            String curRow = "";
            String[] rowElements;
            for (int row = 0; row < numberRows; row++) {
                curRow = matrixRows[row];
                rowElements = curRow.split(" ");
                for (int col = 0; col < numberColumns; col++) {
                    int curElement = Integer.parseInt(rowElements[col]);
                    matrix[row][col] = curElement;
                }
            }
            this.matrix = matrix;

        } else {
            String matrixRows = matrixAsString;
            numberRows = 1;
            numberColumns = (matrixRows.length() + 1) / 2;

            int[][] matrix = new int[numberRows][numberColumns];
            String curRow = matrixRows;
            String[] rowElements = curRow.split(" ");
            for (int col = 0; col < numberColumns; col++) {
                int curElement = Integer.parseInt(rowElements[col]);
                matrix[0][col] = curElement;
            }
            this.matrix = matrix;
        }

        this.rowsCount = numberRows;
        this.columnsCount = numberColumns;
    }

    public int getRowsCount() {
        return this.rowsCount;
    }

    public int getColumnsCount() {
        return this.columnsCount;
    }

    public int[] getRow(int index) {
        return IntStream.range(0, this.getColumnsCount())
                .map(i -> matrix[index][i])
                .toArray();
    }

    public int[] getColumn(int index) {
        return IntStream.range(0, this.getRowsCount())
                .map(i -> matrix[i][index])
                .toArray();
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix("0 1");

        System.out.println(Arrays.toString(matrix.getRow(0)));
    }
}
