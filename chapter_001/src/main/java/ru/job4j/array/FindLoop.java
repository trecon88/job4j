package ru.job4j.array;

/**
 * Класс для поиска элемента в массиве.
 */
public class FindLoop {
    public int indexOf(int[] data, int element) {
        int result = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index <= data.length - 1; index++) {
            if (data[index] == element) {
                result = index;
                break;
            }
        }
        return result;
    }
}
