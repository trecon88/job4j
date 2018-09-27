package ru.job4j.profession;

/**
 * Класс профессия.
 */
public class Profession {
    /**
     * Имя.
     */
    private String name;
    /**
     * Наименование профессии.
     */
    private String profession;

    /**
     * Получить имя.
     * @return Имя
     */
    public String getName() {
        return this.name;
    }
    /**
     * Получить профессию.
     * @return Профессия.
     */
    public String getProfession() {
        return this.profession;
    }

    /**
     * Изменить имя.
     * @param name Новое имя.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Изменить Профессию.
     * @param profession Новая профессия.
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }
}