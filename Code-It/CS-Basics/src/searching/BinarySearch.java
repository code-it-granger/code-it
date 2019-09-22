package searching;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int array[] = {12, 13, 15, 34, 56, 63, 76, 99};
        int key = 99;
        b.iterative(array, key, 0, array.length - 1);
        b.recursive(array, key, 0, array.length - 1);
    }

    public void iterative(int[] array, int key, int start, int end) {
        if (array == null || array.length == 0) {
            System.out.println("Invalid input");
            return;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == array[mid]) {
                System.out.println("Iterative : Element found at: " + mid);
                return;
            } else if (key < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("Iterative : Element not found");

    }

    public void recursive(int[] array, int key, int start, int end) {
        if(array!=null || array.length>0 || key!='\0') {
            if (start <= end) {
                int mid = start + (end - start) / 2;
                if (key == array[mid]) {
                    System.out.println("Recursive : Element found at: " + mid);
                    return;
                } else if (key < array[mid]) {
                    recursive(array, key, start, mid - 1);
                } else recursive(array, key, mid + 1, end);
            }
            else
                System.out.println("Recursive : Element not found");
        }else
            System.out.println("Invalid input");
    }
}
