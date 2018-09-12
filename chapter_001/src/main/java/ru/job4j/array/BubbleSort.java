package ru.job4j.array;

/**
 * Класс для сортировки массива методом пузырька.
 */
public class BubbleSort {
    /**
     * Сортировка массива.
     * @param array Массив для сортировки.
     * @return Отсортированный массив.
     */
    public int[] sort(int[] array) {
        int length = array.length - 1;
        while (length > 0) {
            for (int i = 0; i < length; i++) {
                if (array[i] > array[i + 1]) {
                    swapElements(array, i, i + 1);
                }
            }
            length--;
        }
        return array;
    }
    /**
     * Меняет местами значения двух элементов массива.
     * @param array Массив.
     * @param first Индекс первого элемента.
     * @param second Индекс второго элемента.
     */
    private void swapElements(int[] array, int first, int second) {
        int temp;
        temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}