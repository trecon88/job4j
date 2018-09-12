package ru.job4j.array;

/**
 * Класс для проверки диагоналей массива.
 */
public class MatrixCheck {
    /**
     * Метод проверяет равни ли все элементы по диагоналям true или false.
     * @param data Массив для проверки
     * @return результат.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int length = data.length;
        for (int i = 0; i < length; i++) {
            if (data[i][i] != data[0][0] || data[length - 1 - i][i] != data[length - 1][0]) {
                result = false;
                break;
            }
        }
        return result;
        /* 5. В задании нельзя использовать дополнительный массив.
        int length = data.length;
        boolean result = true;
        boolean[] firstDiagonal = new boolean[length];
        boolean[] secondDiagonal = new boolean[length];
        for (int i = 0; i < length; i++) {
            firstDiagonal[i] = data[i][i];
            secondDiagonal[i] = data[length - 1 - i][i];
        }
        Check check = new Check();
        return check.mono(firstDiagonal) && check.mono(secondDiagonal);
        */
    }
}
