package arrays.OneD;

import java.util.Arrays;

public class ProductOfNumbersExcptIndex {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int[] result = product(a);
        System.out.println(Arrays.toString(result));
    }

    public static int[] product(int[] a){
        int[] result = new int[a.length];
        int temp=1;
        for(int i=0;i<result.length;i++)
            result[i]=1;

        for(int i=0;i<result.length;i++){
            result[i]=temp;
            temp *= a[i];
        }

        temp=1;

        for(int i=a.length-1;i>=0;i--){
            result[i] *= temp;
            temp *= a[i];
        }

        return result;
    }
}
