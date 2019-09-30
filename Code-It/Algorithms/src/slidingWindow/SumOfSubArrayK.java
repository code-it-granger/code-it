package slidingWindow;

import java.util.Arrays;

public class SumOfSubArrayK {
    public static void main(String[] args) {
        int[] a = {1,4,39,2,3,5,11,22,6};
        int k=3;
        SumOfSubArrayK sumOfSubArrayK = new SumOfSubArrayK();
        int[] result = sumOfSubArrayK.sumOfSubArrayK(a,k);
        System.out.println(Arrays.toString(result));
    }

    public int[] sumOfSubArrayK(int[] a, int k){
        if(a==null || a.length==0 || k<=1)
            return null;
        int[] result = new int[a.length-k+1];
        int start_index=0;
        int winSum=0;
        for(int winEnd=0;winEnd<a.length;winEnd++){
            winSum += a[winEnd];

            if(winEnd>=k-1){
                result[start_index]=winSum;
                winSum -= a[start_index];
                start_index++;
            }
        }

        return result;
    }
}
