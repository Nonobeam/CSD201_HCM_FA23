package sort;
class Heap{
    public void heapify(int a[], int N, int i){
        int arr[] = a;
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[largest])
            largest = l;

        if (r < N && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }

    public void buildHeap(int a[]) {
        int arr[] = a;
        int N = arr.length;
        int startIdx = (N / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, N, i);
        }
    }

    private int[] rebuildList(int arr[]){
        int result[] = new int[arr.length - 1];
        int index = 0;
        for (int i = 1; i < arr.length; i++){
            result[index] = arr[i];
            index++;
        }
        return result;
    }
    public void HeapSort(int arr[]){
        buildHeap(arr);
        int sub[] = arr;
        for (int i = 0; i < arr.length; i++){
            System.out.print(sub[0] + " ");
            sub = rebuildList(sub);
            buildHeap(sub);
        }
    }

    public void printHeap(int arr[]){
        int sub[] = arr;
        buildHeap(sub);
        for (int index = 0; index < sub.length; index++){
            System.out.print(sub[index] + " ");
        }
    }
}
class MySort{
    public void SelectionSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minPosition] > a[j]) {
                    minPosition = j;
                }
            }

            int c = a[i];
            a[i] = a[minPosition];
            a[minPosition] = c;
        }
        printAll(a);
    }

    public void InsertSort(int[] a){
        for (int i = 1; i < a.length; i++){
            int val = a[i];
            int index = i - 1;
            while (a[index] > a[i] && index >= 0){
                a[i] = a[i-1];
                index -= 1;
            }
            a[index + 1] = val;
        }
        printAll(a);
    }

    public void BubbleSort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = i + 1; j < a.length; j++){
                if (a[i] > a[j]){
                    int c = a[j];
                    a[j] = a[i];
                    a[i] = c;
                }
            }
        }
        printAll(a);
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int partitionFirst(int arr[], int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        //push to mid
        arr[left] = arr[j];
        arr[j] = pivot;

        return j;
    }
    public void QuickSortFirstPivot(int[] arr, int left, int right){
        if (left < right){
            int pivot = partitionFirst(arr, left, right);
            QuickSortFirstPivot(arr, left, pivot - 1);
            QuickSortFirstPivot(arr, pivot + 1, right);
        }
    }

    public int partitionMiddle(int arr[], int left, int right, int mid) {
        int pivot = arr[mid];
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    public void QuickSortMiddlePivot(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int pivot = partitionMiddle(arr, left, right, mid);
            QuickSortMiddlePivot(arr, left, pivot - 1);
            QuickSortMiddlePivot(arr, pivot, right);
        }
    }

    public int partitionLast(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        //push to mid
        arr[right] = arr[i];
        arr[i] = pivot;

        return i;
    }
    public void QuickSortLastPivot(int[] arr, int left, int right){
        if (left < right){
            int pivot = partitionFirst(arr, left, right);
            QuickSortFirstPivot(arr, left, pivot - 1);
            QuickSortFirstPivot(arr, pivot + 1, right);
        }
    }

//    public void MergePartition(int[] arr, int start, int end, int indexPivot){
//        int pivot;
//        int arrS[];
//        int arrR[];
//        int result[];
//
//        if (arr.length == 1){
//            l,,,
//        }
//
//        while (start < end){
//            while (arr[start] < arr[end]){
//                start++;
//            }
//            while (arr[]){
//
//            }
//
//            if (arrS[pivot] < arrR[0]){
//                int index = 0;
//                for (int i = 0; i < arrS.length; i++){
//                    result[i] = arrS[index];
//                    index++;
//                }
//                int j = 0;
//                for (int i = arrS.length + 1; i < arrR.length; i++){
//                    result[i] = arrR[j];
//                    j++;
//                }
//            }
//        }
//    }

//    public void MergeSort(int[] arr, int s, int e){
//        MergePartition(arr, s, e, arr.length / 2);
//    }

    public void printAll(int[] b){
        for (int i = 0; i < b.length; i++){
            System.out.print(b[i] + " ");
        }
    }
}

public class Sort {
    public static void main(String[] args) {
        int[] a = {5, 1, 8, 2, 7, 3, 9, 4, 6};
        MySort s = new MySort();
        Heap h = new Heap();
//        System.out.println("Print all");
//        s.printAll(a);
//        System.out.println("");
//        System.out.println("Selection Sort");
//        s.SelectionSort(a);
//        System.out.println("");
//        System.out.printf("");
//        System.out.println("Insert Sort");
//        s.InsertSort(a);
        System.out.println("");
        System.out.println("Bubble Sort");
        s.BubbleSort(a);
//        System.out.println("");
//        System.out.println("Heap Sort");
//        h.HeapSort(a);
//        System.out.println("");
//        System.out.println("Quick Sort at first");
//        s.QuickSortFirstPivot(a, 0, 8);
//        s.printAll(a);
//        System.out.println("");
//        System.out.println("Quick Sort at middle");
//        s.QuickSortMiddlePivot(a, 0, 8);
//        s.printAll(a);
//        System.out.println("");
//        System.out.println("Quick Sort at last");
//        s.QuickSortLastPivot(a, 0, 8);
//        s.printAll(a);
//        System.out.println("");
//        System.out.println("Merge Sort");
//        s.MergeSort(a, 0, 8);
//        s.printAll(a);
    }
}
