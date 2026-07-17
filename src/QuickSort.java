public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSortRec(arr, 0, arr.length - 1);
    }

    private static void quickSortRec(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortRec(arr, low, pivotIndex - 1);
            quickSortRec(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low;
        int right = high;

        while (left < right) {
            while (left < right && arr[right] >= pivot)
                right--;
            arr[left] = arr[right];

            while (left < right && arr[left] <= pivot)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
