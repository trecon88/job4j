package ru.job4j.tracker;

import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Переменная для создания случайных чисел.
     */
    private static final Random RN = new Random();

    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод реализующий редактирование заявки по её id.
     * @param id Идентификатор заявки.
     * @param item Заявка.
     */
    public void replace(String id, Item item) {
        int itemIndex = this.findIndexById(id);
        if (itemIndex != -1) {
            item.setId(this.items[itemIndex].getId());
            this.items[itemIndex] = item;
        }
    }

    /**
     * Метод реализующий удаление заявки по её id.
     * @param id Идентификатор заявки.
     */
    public void delete(String id) {
        int itemIndex = this.findIndexById(id);
        if (itemIndex != -1) {
            System.arraycopy(items, itemIndex + 1, items, itemIndex, this.position - itemIndex - 1);
            this.items[position - 1] = null;
            this.position--;
        }
    }

    /**
     * Метод реализующий получение списка всех заявок.
     * @return Список заявок.
     */
    public Item[] findAll() {
        Item[] result;
        if (this.position == 0) {
            result = null;
        } else {
            result = new Item[this.position];
            System.arraycopy(items, 0, result, 0, this.position);
        }
        return result;
    }

    /**
     * Метод реализующий получение списка по имени.
     * @param key Имя.
     * @return Список совпадений.
     */
    public Item[] findByName(String key) {
        int counter = 0;
        Item[] tempArray = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                tempArray[counter++] = items[i];
            }
        }
        Item[] result = null;
        if (counter > 0) {
            result = new Item[counter];
            System.arraycopy(tempArray, 0, result, 0, counter);
        }
        return result;
    }

    /**
     *  Метод реализующий получение заявки по id.
     * @param id Идентификатор заявки.
     * @return Заявка.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод возвращает индекс элемента найденного по Id.
     * @param id Идентификатор элемента.
     * @return Индекс.
     */
    private int findIndexById(String id) {
        int result = -1;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}