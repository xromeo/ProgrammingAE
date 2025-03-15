package easy;

import java.util.HashMap;
import java.util.Map;

public class NumMostPopular {

    public static int findMostFrequentNumber(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Contar la frecuencia de cada número en el array
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int mostFrequentNumber = array[0]; // Suponemos que el primer número es el más frecuente
        int maxFrequency = frequencyMap.get(array[0]); // Frecuencia del primer número
        
        // Determinar el número más frecuente y más pequeño
        for (int i = 1; i < array.length; i++) {
            int currentFrequency = frequencyMap.get(array[i]);
            if (currentFrequency > maxFrequency || (currentFrequency == maxFrequency && array[i] < mostFrequentNumber)) {
                mostFrequentNumber = array[i];
                maxFrequency = currentFrequency;
            }
        }
        
        return mostFrequentNumber;
    }
    
    public static void main(String[] args) {
        int[] array = {22, 101, 102, 101, 102,525,88}; // Ejemplo de array
        
        int mostFrequentNumber = findMostFrequentNumber(array);
        System.out.println("El número más frecuente y menor es: " + mostFrequentNumber);
    }
}
