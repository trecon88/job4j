package ru.job4j.tracker;

import java.util.Date;

/**
 * Класс заявка.
 */
public class Item {
    /**
     * Уникальный идентификатор.
     */
    private String id;
    /**
     * Имя заявки.
     */
    private String name;
    /**
     * Описание заявки.
     */
    private String desc;
    /**
     * Дата создания заявки в милисек.
     */
    private long created;
    /**
     * Массив комментариев.
     */
    private String[] comments;

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.created = System.currentTimeMillis();
    }

    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDesc() {
        return this.desc;
    }
    public long getCreated() {
        return  this.created;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public String toString() {
        String title = "Id \t Имя \t Дата создания \t Описание";
        return String.format("%s\r\n%s\t%s\t%s\t%s", title, this.getId(), this.getName(), new Date(this.getCreated()).toString(), this.getDesc());
        //return super.toString();
    }
}
