package ru.job4j.pseudo;
/**
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("++++");
        pic.append("++++");
        pic.append("++++");
        return pic.toString();
    }
}
