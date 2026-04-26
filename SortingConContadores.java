import java.util.Arrays;

/**
 * Contadores y Pruebas - Paso 3 y 4 de la actividad
 * Ejecuta Bubble Sort (todas las versiones) y Selection Sort
 * sobre los tres arreglos del enunciado, registrando
 * comparaciones e intercambios.
 */
public class SortingConContadores {

    // -------------------------------------------------------
    // Resultado de una ejecución
    // -------------------------------------------------------
    static class Resultado {
        String algoritmo;
        int[] entrada;
        int[] salida;
        int comparaciones;
        int intercambios;

        Resultado(String algoritmo, int[] entrada, int[] salida,
                  int comparaciones, int intercambios) {
            this.algoritmo    = algoritmo;
            this.entrada      = entrada;
            this.salida       = salida;
            this.comparaciones = comparaciones;
            this.intercambios  = intercambios;
        }

        @Override
        public String toString() {
            return String.format("%-35s | entrada: %-16s | salida: %-16s | comp: %3d | swap: %3d",
                algoritmo,
                Arrays.toString(entrada),
                Arrays.toString(salida),
                comparaciones,
                intercambios);
        }
    }

    // -------------------------------------------------------
    // Bubble Sort base
    // -------------------------------------------------------
    static Resultado bubbleBase(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        int comp = 0, swap = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                comp++;
                if (a[j] > a[j + 1]) {
                    int tmp = a[j]; a[j] = a[j+1]; a[j+1] = tmp;
                    swap++;
                }
            }
        }
        return new Resultado("Bubble Base", arr, a, comp, swap);
    }

    // -------------------------------------------------------
    // Bubble Sort Mejora 1 (swapped)
    // -------------------------------------------------------
    static Resultado bubbleMejora1(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        int comp = 0, swap = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1; j++) {
                comp++;
                if (a[j] > a[j + 1]) {
                    int tmp = a[j]; a[j] = a[j+1]; a[j+1] = tmp;
                    swap++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return new Resultado("Bubble Mejora1 (swapped)", arr, a, comp, swap);
    }

    // -------------------------------------------------------
    // Bubble Sort Mejora 2 (swapped + j < n-i-1)
    // -------------------------------------------------------
    static Resultado bubbleMejora2(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        int comp = 0, swap = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comp++;
                if (a[j] > a[j + 1]) {
                    int tmp = a[j]; a[j] = a[j+1]; a[j+1] = tmp;
                    swap++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return new Resultado("Bubble Mejora2 (j<n-i-1)", arr, a, comp, swap);
    }

    // -------------------------------------------------------
    // Selection Sort
    // -------------------------------------------------------
    static Resultado selectionSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        int comp = 0, swap = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comp++;
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = a[i]; a[i] = a[minIdx]; a[minIdx] = tmp;
                swap++;
            }
        }
        return new Resultado("Selection Sort", arr, a, comp, swap);
    }

    // -------------------------------------------------------
    // main
    // -------------------------------------------------------
    public static void main(String[] args) {

        int[][] arreglos = {
            {5, 3, 8, 2},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };

        System.out.println("=".repeat(110));
        System.out.println("RESULTADOS - Algoritmos de Ordenamiento");
        System.out.println("=".repeat(110));
        System.out.printf("%-35s | %-22s | %-22s | %7s | %7s%n",
            "Algoritmo", "Entrada", "Salida", "Comp.", "Swaps");
        System.out.println("-".repeat(110));

        for (int[] arr : arreglos) {
            System.out.println(bubbleBase(arr));
            System.out.println(bubbleMejora1(arr));
            System.out.println(bubbleMejora2(arr));
            System.out.println(selectionSort(arr));
            System.out.println("-".repeat(110));
        }

        // -------------------------------------------------------
        // Análisis embebido (Paso 5)
        // -------------------------------------------------------
        System.out.println();
        System.out.println("=== ANÁLISIS (Paso 5) ===");
        System.out.println();
        System.out.println("1. ¿Qué mejora tuvo mayor impacto en Bubble Sort?");
        System.out.println("   Mejora 1 (swapped). En el caso de arreglo ya ordenado [1,2,3,4,5]");
        System.out.println("   reduce las comparaciones de 16 a 4 (solo 1 pasada), un ahorro del 75%.");
        System.out.println("   Mejora 2 ayuda en todos los casos pero su ganancia es proporcional al tamaño,");
        System.out.println("   mientras que Mejora 1 permite terminación temprana total.");
        System.out.println();
        System.out.println("2. ¿En qué caso Bubble Sort se vuelve más eficiente?");
        System.out.println("   Cuando el arreglo ya está ordenado [1,2,3,4,5]. Con Mejora 1,");
        System.out.println("   detecta en la primera pasada que no hubo swaps y termina en O(n).");
        System.out.println();
        System.out.println("3. Comparación de intercambios entre Bubble y Selection:");
        System.out.println("   Selection Sort siempre hace como máximo (n-1) intercambios (uno por pasada),");
        System.out.println("   porque solo intercambia cuando encuentra el mínimo real.");
        System.out.println("   Bubble Sort puede hacer muchos más swaps porque mueve elementos");
        System.out.println("   en cada comparación, no solo una vez por pasada.");
        System.out.println("   Para [5,4,3,2,1] Bubble hace 10 swaps, Selection solo 2.");
        System.out.println();
        System.out.println("4. ¿Se mantiene O(n²)?");
        System.out.println("   Sí en el caso promedio y peor caso. En el peor caso (arreglo invertido)");
        System.out.println("   ambas mejoras no reducen el orden de magnitud: Θ(n²) comparaciones.");
        System.out.println("   La constante mejora, pero el crecimiento cuadrático se mantiene.");
        System.out.println();
        System.out.println("5. ¿En qué caso Bubble puede ser O(n)?");
        System.out.println("   Cuando el arreglo ya está ordenado y se aplica Mejora 1 (swapped).");
        System.out.println("   Solo se necesita 1 pasada de n-1 comparaciones para confirmar");
        System.out.println("   que no hay intercambios → O(n). Es el mejor caso posible.");
    }
}
