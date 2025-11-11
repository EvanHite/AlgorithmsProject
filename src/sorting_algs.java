public class sorting_algs {
    // Ethan
    public void bubbleSort(int[] arr){
        //bool to break out of loop if no elements are swapped(in order)
        boolean swapped = false;
        int temp;
        for(int i = 0; i < arr.length; i++){
            swapped = false;
            for(int j = 0; j< arr.length - 1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            //if no elements swapped, we don't need to loop again
            if(!swapped)
                break;
        }
    }

    public void selectionSort(int[] arr){
        //moving 'boundary' of unsorted section of array
        for(int i = 0; i<arr.length; i++){
            //find min element in unsorted array
            int min_index = i;
            for(int j = i + 1; j<arr.length;j++){
                if(arr[j]<arr[min_index])
                    min_index = j;
            }

            //swap the minimum element with the first element
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }

    private void merge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid; // Fixed the range by removing the + 1

        //creating temp arrays for l and r subarrs
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        //copying data to temp arrs
        for(int i = 0; i < n1; i++)
            arr1[i] = arr[l+i];
        for(int j = 0; j < n2; j++)
            arr2[j] = arr[mid+1+j];

        int i = 0;
        int j = 0;
        int k = l;

        //merge the temp arrays back into arr
        while(i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        //copy any elems of arr1[] if any left
        while (i < n1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        //same for arr2[]
        while ( j < n2){
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] arr){
        //iterate through subarrays of increasing size
        for(int size = 1; size < arr.length; size = 2 * size) { // Corrected the length here

            //pick our starting points of each subarr
            for (int start = 0; start < arr.length - 1; start += 2* size){
                int mid = Math.min(start + size -1, arr.length - 1);
                int end = Math.min(start + (2 * size) - 1, arr.length - 1);

                //merge our subarrays
                merge(arr, start, mid, end);
            }
        }
    }

    // Evan
    // O(n^2) Time complexity insertion sort
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Quicksort
    //average O(n log n) worst O(n^2)
    public void quickSort(int[] arr) {
        if (arr.length < 2) return;

        int[] stack = new int[arr.length * 2];
        int top = 0;

        // push whole range
        stack[top++] = 0;
        stack[top++] = arr.length - 1;

        while (top > 0) {
            int r = stack[--top];
            int l = stack[--top];

            if (l >= r) continue;

            // partition logic directly here (no helper)
            int pivot = arr[r];
            int i = l - 1;

            for (int j = l; j < r; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            int temp = arr[i + 1];
            arr[i + 1] = arr[r];
            arr[r] = temp;

            int p = i + 1; // pivot index after partition

            // push right side
            stack[top++] = p + 1;
            stack[top++] = r;

            // push left side
            stack[top++] = l;
            stack[top++] = p - 1;
        }
    }

}
