package ru.job4j.array;

/**
 * Класс для формирование таблицы умножения
 */
public class Matrix {
    /**
     * Метод формирующий таблицу умножения.
     * @param size Размер таблицы.
     * @return Массив таблицы.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    table[i][j] = (i + 1) * (j + 1);
                }
            }
        }
        return table;
    }
}
