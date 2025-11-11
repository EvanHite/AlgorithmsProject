import java.util.Arrays;
import java.util.Random;

// Test program to test if the algos work

public class test_algos {
    public static void main(String[] args) {
        sorting_algs algs = new sorting_algs();
        Random rnd = new Random(123);

        // test array size:
        int[] original = new int[20];
        for (int i = 0; i < original.length; i++) original[i] = rnd.nextInt(100);

        System.out.println("Original:");
        System.out.println(Arrays.toString(original));
        System.out.println();
        
        // Test all of the sorting algos
        runTest("Bubble Sort", arr -> algs.bubbleSort(arr), original);
        runTest("Selection Sort", arr -> algs.selectionSort(arr), original);
        runTest("Merge Sort", arr -> algs.mergeSort(arr), original);
        runTest("Merge Sort", arr -> algs.insertionSort(arr), original);
        runTest("Merge Sort", arr -> algs.quickSort(arr), original);
    }

    // Main test function 
    private static void runTest(String name, java.util.function.Consumer<int[]> sorter, int[] original) {
        int[] a = Arrays.copyOf(original, original.length);
        sorter.accept(a);

        System.out.println(name + ":");
        System.out.println(Arrays.toString(a));

        if (isSorted(a)) System.out.println("PASS\n");
        else System.out.println("FAIL\n");
    }

    // Check if its sorted correctly by seeing if they are in order :)
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1]) return false;
        return true;
    }
}
