package arrays.twoD;

import java.util.Arrays;

/*
    Variants:
        1. Every row is sorted. And last element of a row <= first element of next row
        2. Rows are sorted, columns are sorted. Last element of row need not be <= first element of next row
        https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/SearchA2DMatrix/SearchA2DMatrix.java

*/
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] variant1 = {{1, 2, 3},
                {4, 5, 16},
                {17, 28, 39}};
        int key1 = 17;
        int[] index = search(variant1, key1);
       System.out.println(Arrays.toString(index));

        int[][] variant2={{1,3,6},
                {4,5,8},
                {9,10,19}};
        int key2=19;
        int[] index2 = search2(variant2,key2);
        System.out.println(Arrays.toString(index2));
    }

    public static int[] search(int[][] a, int k) {
        if (a == null || a.length == 0 || k == '\0')
            return null;
        /*
        Index i will always be in locations:
            row = i/totalColumns
            col = i%totalColumns
         */

        int startIndex = 0;
        int endIndex = a.length * a[0].length - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            int midElement = a[mid / a[0].length][mid % a[0].length];

            if (midElement == k)
                return new int[]{mid / a[0].length, mid % a[0].length};
            else if (k < midElement)
                endIndex = mid - 1;
            else
                startIndex = mid + 1;
        }
        return null;
    }

    public static int[] search2(int[][] a, int k){
        /*
        Start off at the bottom left
        1. Check if the value == value at bottom-left
        2. If not, the value can only be in rows above it(there are no columns before it)
        3. Check the first element above bottom-left. if value==key, return.
        */

        int row=a.length-1;
        int col = 0;

        while(row>=0 && col<a[0].length){
            if(k == a[row][col])
                return new int[]{row,col};
            else if(k < a[row][col])
                row--;
            else
                col++;
        }

        return null;
    }

}
