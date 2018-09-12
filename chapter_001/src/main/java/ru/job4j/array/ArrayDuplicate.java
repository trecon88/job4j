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
        int length = array.length - 1;
        int tempInd;
        for (int i = 0; i <= length; i++) {
            tempInd = i + 1;
            while (tempInd <= length) {
                if (array[i].equals(array[tempInd])) {
                    this.swap(array, tempInd, length);
                    length--;
                    continue;
                }
                tempInd++;
            }
        }
        return Arrays.copyOf(array, length + 1);
    }
    /**
     * Перемещает элемент.
     * @param array Изменяемый массив.
     * @param index Номер элемента.
     * @param newIndex Номер элемента куда следует перенести.
     */
    private void swap(String[] array, int index, int newIndex) {
        String temp;
        for (int i = index; i < newIndex; i++) {
            temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }
}
