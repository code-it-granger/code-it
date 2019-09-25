package arrays.twoD;

/*
    Rotate matrix either in clockwise, or non-clockwise direction by 90 degrees
    https://www.techiedelight.com/place-rotate-matrix-90-degrees-clock-wise-direction/
*/

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        print(a);
        rotateClockWise(a);
        rotateAntiClockWise(a);
    }

    public static void rotateClockWise(int[][] mat) {
        int n = mat.length;

        //transpose the matrix
        int[][] a = transpose(mat);

        //swap the cols
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][n - j - 1];
                a[i][n - j - 1] = temp;
            }
        }
        print(a);
    }

    public static void rotateAntiClockWise(int[][] mat) {
        int n=mat.length;
        int[][] a = transpose(mat);

        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = a[i][j];
                a[i][j]=a[n-i-1][j];
                a[n-i-1][j]=temp;
            }
        }
        print(a);

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
        System.out.println();
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++)
                System.out.print(a[row][col] + " ");
            System.out.println();
        }
    }
}
