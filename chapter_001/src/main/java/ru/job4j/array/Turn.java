package ru.job4j.array;

/**
 * Класс для переворачивания массива задом наперед.
 */
public class Turn {
    /**
     * Метод переворачиваюший массив.
     * @param array Массив.
     * @return Перевернутый массив.
     */
    public int[] turn(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}