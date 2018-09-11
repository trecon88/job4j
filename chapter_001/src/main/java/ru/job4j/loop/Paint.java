package ru.job4j.loop;

/**
 * Класс который должен рисовать пирамиду из символа ^ и пробелов.
 */
public class Paint {
    /**
     * Вывод пирамиды.
     * @param height Высота пирамиды
     * @return Пирамида.
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int width = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * Вывод правой части пирамиды.
     * @param height Высота пирамиды
     * @return Правая часть пирамида.
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        // ширина будет равна высоте.
        int width = height;
        // внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != width; column++) {
                // если строка равна ячейки, то рисуем галку.
                // в данном случае строка определяем, сколько галок будет на строке
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод строки.
            screen.append(System.lineSeparator());
        }
        // Получаем результат.
        return screen.toString();
    }
    /**
     * Вывод левой части пирамиды.
     * @param height Высота пирамиды
     * @return Левая часть пирамида.
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= width - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
