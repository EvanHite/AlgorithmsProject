public class driver {
    public static void main(String[] args)
    {
        //driver for bubble, selection, and merge
        sorting_algs sort = new sorting_algs();

        //example array
        int[] arr = {3,5,4,1,2};

        //test bubble sort
        sort.bubbleSort(arr);
        for (int i = 0; i < arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();

        //unsort again
        arr = new int[]{3, 5, 4, 1, 2};

        //test selection
        sort.selectionSort(arr);
        for (int i = 0; i < arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();

        //unsort again
        arr = new int[]{3, 5, 4, 1, 2};

        //test merge
        sort.mergeSort(arr);
        for (int i = 0; i < arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
