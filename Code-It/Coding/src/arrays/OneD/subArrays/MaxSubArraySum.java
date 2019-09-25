package arrays.OneD.subArrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] a = {1,40,2,3,6,5,7,31,12};
        int maxSum = maxSumSubArray(a,4);
        System.out.println(maxSum);
    }

    public static int maxSumSubArray(int[] a, int k){
        int maxSum = Integer.MIN_VALUE;

        int winStart=0;
        int winSum=0;

        for(int winEnd=0;winEnd<a.length;winEnd++){
            winSum += a[winEnd];
            if(winEnd >= k-1) {
                maxSum = Math.max(winSum, maxSum);
                winSum -=a[winStart];
                winStart++;
            }
        }

        return maxSum;
    }
}
