package slidingWindow;

public class MaxSumSubArrayK {
    public static void main(String[] args) {
        int[] a={1,4,39,2,3,5,11,22,6};
        int k=3;
        MaxSumSubArrayK maxSumSubArrayK=new MaxSumSubArrayK();
        System.out.println(maxSumSubArrayK.maxSum(a,k));
    }
    public int maxSum(int[] a, int k){
        int max=Integer.MIN_VALUE;
        int sum=0; int winStart=0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
            if(i >= k-1){
                max = Math.max(max,sum);
                sum -= a[winStart];
                winStart++;
            }
        }

        return max;
    }
}
