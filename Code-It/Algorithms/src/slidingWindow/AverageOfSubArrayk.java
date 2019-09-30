package slidingWindow;

import java.util.Arrays;

public class AverageOfSubArrayk {
    public static void main(String[] args) {
        int[] a = {1,4,2,3,5,11,22,6};
        int k=3;
        AverageOfSubArrayk averageOfSubArrayk = new AverageOfSubArrayk();
        double[] result = averageOfSubArrayk.avgOfSubArrayK(a,k);
        System.out.println(Arrays.toString(result));
    }

    public double[] avgOfSubArrayK(int[] a, int k){
        if(a==null || a.length==0 || k<=1)
            return null;
        double[] result = new double[a.length-k+1];
        int start_index=0;
        double winSum=0;
        for(int winEnd=0;winEnd<a.length;winEnd++){
            winSum += a[winEnd];

            if(winEnd>=k-1){
                result[start_index]=winSum/k;
                winSum -= a[start_index];
                start_index++;
            }
        }

        return result;
    }
}

