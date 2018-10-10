package ru.job4j.tracker;

public class AddItem implements UserAction {
    @Override
    public int key() {
        return StartUI.ADD;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки : ");
        String desc = input.ask("Введите описание заявки : ");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
    }

    @Override
    public String info() {
        return "Add new Item.";
    }
}
