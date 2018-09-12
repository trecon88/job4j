package ru.job4j.array;

/**
 * Класс для проверки массива.
 */
public class Check {
    /**
     * Метод проверяет, что все элементы в массиве являются true или false.
     * @param data Массив
     * @return Если все элементы true или false, то true, иначе false.
     */
    public boolean mono(boolean[] data) {
        //if (data.length == 0) return false;
        boolean temp = data[0];
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != temp) {
                result = false;
                break;
            }
        }
        return result;
    }
}
