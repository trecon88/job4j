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
                if (array[i] <= array[i + 1]) {
                    if (i == length - 1) {
                        length--;
                    }
                } else {
                    swapElements(array, i, i + 1);
                }
            }
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
        int length = array.length;
        int temp;
        if ((first >= 0 && first < length) && (second >= 0 && second < length)) {
            temp = array[first];
            array[first] = array[second];
            array[second] = temp;
        }
    }
}
