package twoPointer;

import java.util.Arrays;

public class PairWithTargetSum {
    public static void main(String[] args) {
        PairWithTargetSum p = new PairWithTargetSum();
        int[] a = {12,13,20,23,25,30,35};
        int sum = 65;
        int[] res = p.targetSum(a,sum);
        System.out.println(Arrays.toString(res));
    }

    public int[] targetSum(int[] a, int sum){
        if(a==null || a.length==0)
            return null;
        int start=0, end=a.length-1;
        while(start < end){
            int diff = sum-a[start];
            if(diff == a[end])
                return new int[]{a[start], a[end]};
            else if(diff > a[end]){
               start++;
            }
            else end--;
        }
        return new int[]{-1,-1};
    }
}
