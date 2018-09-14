package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс для работы с массивами.
 */
public class ArrayDuplicate {
    /**
     * Метод убрирает все дубликаты строк из массива.
     * @param array Массив со строками.
     * @return Измененный массив.
     */
    public String[] remove(String[] array) {
        int length = array.length;
        for (int out = 0; out < length; out++) {
            int in = out + 1;
            while (in < length) {
                if (array[out].equals(array[in])) {
                    array[in] = array[length - 1];
                    length--;
                    in--;
                }
                in++;
            }
        }
        return Arrays.copyOf(array, length);
    }
}
