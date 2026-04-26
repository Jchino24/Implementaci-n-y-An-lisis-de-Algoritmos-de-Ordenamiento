/**
 * Bubble Sort - Versión Base
 * Sin optimizaciones, implementación clásica.
 */
public class BubbleSortBase {

    public static int[] sort(int[] arr) {
        int n = arr.length;
        int[] a = arr.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {5, 3, 8, 2},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };

        System.out.println("=== Bubble Sort Base ===");
        for (int[] test : tests) {
            int[] result = sort(test);
            System.out.print("Entrada: " + java.util.Arrays.toString(test));
            System.out.println("  →  Salida: " + java.util.Arrays.toString(result));
        }
    }
}
