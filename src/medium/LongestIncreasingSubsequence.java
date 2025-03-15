package medium;

/*
 Longest Increasing Subsequence (LIS)
Dado un arreglo arr[] de tamaño N, el objetivo es encontrar la longitud de la subsecuencia creciente más larga (LIS), es decir, la subsecuencia más larga en la que los elementos están ordenados en orden creciente.

Ejemplos
Entrada: arr[] = {3, 10, 2, 1, 20}
Salida: La LIS más larga es {3, 10, 20} (longitud 3).
Entrada: arr[] = {3, 2}
Salida: Las LIS más largas son {3} y {2} (longitud 1).
Entrada: arr[] = {50, 3, 10, 7, 40, 80}
Salida: La LIS más larga es {3, 7, 40, 80} (longitud 4).
Algoritmo

El algoritmo LIS se basa en la siguiente idea:

Definimos L(i) como la longitud de la LIS que termina en el índice i, donde arr[i] es el último elemento de la LIS.
Entonces, L(i) se puede escribir recursivamente como:

L(i) = 1 + max(L(j)) donde 0 < j < i y arr[j] < arr[i], o
L(i) = 1 si no existe tal j.
La longitud de la LIS que termina en el índice i es 1 más el máximo de las longitudes de todas las LIS que terminan en algún índice j tal que arr[j] < arr[i].
 * 
 */
public class LongestIncreasingSubsequence {

    public static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // Almacena las longitudes de LIS

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Inicialización: cada elemento es una LIS de longitud 1
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 10, 2, 1, 20 };
        System.out.println("Longitud de la LIS: " + longestIncreasingSubsequence(arr));
    }

}
