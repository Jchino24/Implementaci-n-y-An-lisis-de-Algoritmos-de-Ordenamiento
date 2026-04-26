/**
 * Bubble Sort - Mejora 2
 * Combina Mejora 1 (swapped) + reducción del ciclo interno.
 *
 * ¿Por qué j < n - i - 1?
 * Después de cada pasada i, el elemento más grande "burbujea"
 * hasta su posición final al final del arreglo.
 * En la pasada i=0 el mayor queda en pos n-1,
 * en i=1 el segundo mayor queda en n-2, etc.
 * Por tanto ya no es necesario comparar los últimos i elementos
 * → el ciclo interno se acorta i posiciones en cada iteración.
 */
public class BubbleSortMejora2 {

    public static int[] sort(int[] arr) {
        int n = arr.length;
        int[] a = arr.clone();

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {   // <-- Mejora 2
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {5, 3, 8, 2},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };

        System.out.println("=== Bubble Sort Mejora 2 (ciclo reducido) ===");
        for (int[] test : tests) {
            int[] result = sort(test);
            System.out.print("Entrada: " + java.util.Arrays.toString(test));
            System.out.println("  →  Salida: " + java.util.Arrays.toString(result));
        }
    }
}
