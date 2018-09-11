package ru.job4j.array;

/**
 * Класс для заполнения массива числами возведенными в квадрат.
 */
public class Square {
    /**
     * Метод заполняющий массив числами возведенными в квадрат.
     * @param bound Квадрат чисел от 1 до bound.
     * @return Массив чисел.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 0; i <= result.length - 1; i++) {
            result[i] = (int) Math.pow(i + 1, 2);
        }
        return result;
    }
}
