package ru.job4j.tracker;

public class FindItemsByName implements UserAction {
    @Override
    public int key() {
        return StartUI.FIND_BY_NAME;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявок по имени --------------");
        String name = input.ask("Введите имя заявки : ");
        Item[] foundItems = tracker.findByName(name);
        if (foundItems != null) {
            System.out.println("Id \t Имя \t Дата создания \t Описание");
            for (Item item : foundItems) {
                System.out.println(item);
            }
            System.out.println("------------ Конец списка --------------");
        } else {
            System.out.println("------------ Не найдено заявок с именем : " + name + " --------------");
        }
    }

    @Override
    public String info() {
        return "Find items by name.";
    }
}
