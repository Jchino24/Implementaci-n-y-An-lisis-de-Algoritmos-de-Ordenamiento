/**
 * Bubble Sort - Mejora 1
 * Detección de arreglo ya ordenado mediante variable "swapped".
 * Si no hubo intercambios en una pasada, el arreglo ya está ordenado
 * y el algoritmo termina anticipadamente → O(n) en el mejor caso.
 */
public class BubbleSortMejora1 {

    public static int[] sort(int[] arr) {
        int n = arr.length;
        int[] a = arr.clone();

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;                  // <-- Mejora 1

            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;                   // hubo intercambio
                }
            }

            if (!swapped) break;                      // arreglo ya ordenado
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {5, 3, 8, 2},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };

        System.out.println("=== Bubble Sort Mejora 1 (detección de ordenado) ===");
        for (int[] test : tests) {
            int[] result = sort(test);
            System.out.print("Entrada: " + java.util.Arrays.toString(test));
            System.out.println("  →  Salida: " + java.util.Arrays.toString(result));
        }
    }
}
