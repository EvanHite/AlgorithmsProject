import java.util.Arrays;
import java.util.Random;

public class driver {
    // Configure
    static int[] SIZES = {1000, 2000, 10000, 20000}; // Differnt size arrays to test we need at least 10
    static int TRIALS = 10; // How many trials per array size (at least 10)

    public static void main(String[] args) {
        sorting_algs algs = new sorting_algs();
        Random seed = new Random(12345);

        System.out.println("dataset,size,algo,avg_ms");
        System.out.println("========================");
        System.out.println("");

        // Loop for each size array
        for (int n : SIZES) {

            // Test several data anomalies
            // Create random array of size n
            int[] baseRandom = randomArray(n, seed);

            // Create a sorted array of size n
            int[] baseSorted = Arrays.copyOf(baseRandom, n);
            Arrays.sort(baseSorted);

            // Create an array of size n where every element is 7
            int[] baseEqual  = equalArray(n, 7);

            // bubble tests
            printRow("random", n, "bubble", avgMs(() -> algs.bubbleSort(copy(baseRandom)), TRIALS));
            printRow("sorted", n, "bubble", avgMs(() -> algs.bubbleSort(copy(baseSorted)), TRIALS));
            printRow("equal",  n, "bubble", avgMs(() -> algs.bubbleSort(copy(baseEqual)),  TRIALS));
            System.out.println("");

            // selection tests
            printRow("random", n, "selection", avgMs(() -> algs.selectionSort(copy(baseRandom)), TRIALS));
            printRow("sorted", n, "selection", avgMs(() -> algs.selectionSort(copy(baseSorted)), TRIALS));
            printRow("equal",  n, "selection", avgMs(() -> algs.selectionSort(copy(baseEqual)),  TRIALS));
            System.out.println("");

            // merge tests
            printRow("random", n, "merge", avgMs(() -> algs.mergeSort(copy(baseRandom)), TRIALS));
            printRow("sorted", n, "merge", avgMs(() -> algs.mergeSort(copy(baseSorted)), TRIALS));
            printRow("equal",  n, "merge", avgMs(() -> algs.mergeSort(copy(baseEqual)),  TRIALS));
            System.out.println("");

            // iterative tests
            printRow("random", n, "iterative", avgMs(() -> algs.insertionSort(copy(baseRandom)), TRIALS));
            printRow("sorted", n, "iterative", avgMs(() -> algs.insertionSort(copy(baseSorted)), TRIALS));
            printRow("equal",  n, "iterative", avgMs(() -> algs.insertionSort(copy(baseEqual)),  TRIALS));
            System.out.println("");

            // quick tests
            printRow("random", n, "quick", avgMs(() -> algs.quickSort(copy(baseRandom)), TRIALS));
            printRow("sorted", n, "quick", avgMs(() -> algs.quickSort(copy(baseSorted)), TRIALS));
            printRow("equal",  n, "quick", avgMs(() -> algs.quickSort(copy(baseEqual)),  TRIALS));
            System.out.println("");
        }
    }

    // timing helper
    private static double avgMs(Runnable r, int trials) {
        long sum = 0L;
        for (int i = 0; i < trials; i++) {
            long t0 = System.nanoTime();
            r.run();
            long t1 = System.nanoTime();
            sum += (t1 - t0);
        }
        return sum / (double) trials / 1_000_000.0;
    }

    // data helpers
    private static int[] randomArray(int n, Random seed) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = seed.nextInt();
        return a;
    }
    private static int[] equalArray(int n, int v) {
        int[] a = new int[n];
        Arrays.fill(a, v);
        return a;
    }
    private static int[] copy(int[] a) { return Arrays.copyOf(a, a.length); }

    // printing helper
    private static void printRow(String dataset, int n, String algo, double ms) {
        System.out.printf("%s,%d,%s,%.3f%n", dataset, n, algo, ms);
    }
}