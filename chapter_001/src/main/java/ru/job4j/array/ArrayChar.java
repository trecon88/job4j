package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    /**
     * Массив с обрабатываемой строкой.
     */
    private char[] data;

    /**
     * Конструктор формирующий массив.
     * @param line Строка для обработки.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value
        if (this.data.length < value.length) {
            result = false;
        } else {
            for (int i = 0; i < value.length; i++) {
                if (this.data[i] != value[i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}