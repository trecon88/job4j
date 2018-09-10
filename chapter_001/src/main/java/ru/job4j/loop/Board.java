package ru.job4j.loop;

/**
 * Класс для определения шахмотной доски.
 */
public class Board {
    /**
     * Метод возвращает шахматную доску.
     * @param width ширина доски.
     * @param height высота доски.
     * @return доска.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
