package arrays.twoD;
/*
    https://www.sanfoundry.com/java-program-display-transpose-matrix/
*/

public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        print(a);
        int[][] transpose = transpose(a);
        System.out.println("\nTranspose: ");
        print(transpose);

    }

    public static int[][] transpose(int[][] a) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < row; col++) {
                int temp = a[row][col];
                a[row][col] = a[col][row];
                a[col][row] = temp;
            }
        }
        return a;
    }

    public static void print(int[][] a) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++)
                System.out.print(a[row][col] + " ");
            System.out.println();
        }
    }
}
