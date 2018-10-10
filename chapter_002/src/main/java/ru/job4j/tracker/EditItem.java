package ru.job4j.tracker;

public class EditItem implements UserAction {
    @Override
    public int key() {
        return StartUI.EDIT;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите ID заявки : ");
        String newName = input.ask("Введите новое имя заявки : ");
        String newDesc = input.ask("Введите новое описание заявки : ");
        if (tracker.replace(id, new Item(newName, newDesc))) {
            System.out.println("------------ Изменена заявка с Id : " + id + " --------------");
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не найдена --------------");
        }
    }

    @Override
    public String info() {
        return "Edit item.";
    }
}
