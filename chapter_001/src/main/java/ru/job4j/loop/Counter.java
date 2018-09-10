package ru.job4j.loop;

/**
 * Class Counter
 * @author contre
 */
public class Counter {
    /**
     * Метод должен вычислять сумму четныx чисел в диапазоне от start до finish.
     * @param start Начальное число.
     * @param finish Конечное число.
     * @return сумма четных чисел
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
