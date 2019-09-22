package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(new int[]{12, 3, 11, 5, 33, 87, 23}));
        int[] array = {12, 3, 11, 5, 33, 87, 23};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
    }

    public void sort(int[] array) {
        if (array.length <= 1)
            return;
        int length = array.length;
        int[] left = new int[length / 2];
        int[] right = new int[length - left.length];
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, length - left.length);

        sort(left);
        sort(right);

        merge(array, left, right);

    }

    public void merge(int[] array, int[] left, int[] right) {
        int index = 0;
        int left_index = 0;
        int right_index = 0;
        while (left_index < left.length && right_index < right.length) {
            if (left[left_index] <= right[right_index]) {
                array[index++] = left[left_index++];
            } else {
                array[index++] = right[right_index++];
            }
        }
        System.arraycopy(left,left_index,array,index,left.length-left_index);
        System.arraycopy(right,right_index,array,index,right.length-right_index);
        System.out.println(Arrays.toString(array));
    }
}
