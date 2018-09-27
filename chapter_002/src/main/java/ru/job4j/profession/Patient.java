package ru.job4j.profession;

/**
 * Пациент.
 */
public class Patient {
    /**
     * Имя пациента.
     */
    private String name;

    /**
     * Получить имя.
     * @return Имя.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Изменить имя.
     * @param name Имя.
     */
    public void setName(String name) {
        this.name = name;
    }
}
