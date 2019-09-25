package arrays.OneD.subArrays;

import java.util.Arrays;

public class SubArrayAvg {
    public static void main(String[] args) {
        int[] a = {2,1,3,6,5,4,21,12,7};
        int k=4;
        double[] result = subArrayAvg(a,k);
        System.out.println(Arrays.toString(result));
    }
    public static double[] subArrayAvg(int[] a, int k){
        if(a==null || a.length==0 || k<=0)
            return null;
        int winStart=0;
        double winSum=0;
        double[] result = new double[a.length-k+1];
        for(int winEnd=0;winEnd<a.length;winEnd++){
            winSum += a[winEnd];
            if(winEnd>=k-1){
                result[winStart]=winSum/k;
                winSum -=a[winStart];
                winStart++;
            }
        }
        return result;
    }
}
