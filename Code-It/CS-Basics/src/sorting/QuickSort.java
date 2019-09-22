package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {12, 3, 11, 5, 33, 87, 23,7};
        QuickSort q = new QuickSort();
        q.quickSort(array,0,array.length-1);
    }
    public void quickSort(int[] array, int start, int end){
        if(array==null || array.length<=1)
            return;

        if(start < end){
            int mid=start+(end-start)/2;
            int pivot = array[mid];
            int i=start, j=end;

            while(i<=j){
                while(array[i]<pivot)
                    i++;
                while(array[j]>pivot)
                    j--;

                if(i<=j){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                    i++;
                    j--;
                }
            }

            if(start<j)
                quickSort(array,start,j);
            if(end> i)
                quickSort(array,i,end);
        }
        System.out.println(Arrays.toString(array));
    }

}
