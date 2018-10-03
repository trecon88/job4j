package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String ls = System.lineSeparator();
    private final String menu = String.format(
            "Меню.%n0. Add new Item.%n1. Show all items.%n2. Edit item.%n3. Delete item.%n4. Find item by Id.%n5. Find items by name.%n6. Exit Program.%nSelect:%n"
    );
    private final String title = String.format(
            "Id \t Имя \t Дата создания \t Описание%n"
    );

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenNotUpdatedThenTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", "someId", "testName", "testDesc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteItemThenDeleted() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        String expected = null;
        assertThat(tracker.findById(item.getId()), is(expected));
    }

    @Test
    public void whenDeletedNotFoundThenTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test", "desc"));
        Input input = new StubInput(new String[]{"3", "someId", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenShowAllThenOutput() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1");
        Item item2 = new Item("name2", "desc2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Список всех заявок --------------")
                                .append(this.ls)
                                .append(this.title)
                                .append(item1)
                                .append(this.ls)
                                .append(item2)
                                .append(this.ls)
                                .append("------------ Конец списка --------------")
                                .append(this.ls)
                                .append(this.menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenShowAllNoItemsThenOutput() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Список заявок пуст --------------")
                                .append(this.ls)
                                .append(this.menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByIdThenOutput() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1");
        tracker.add(item1);
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Поиск заявки по ID --------------")
                                .append(this.ls)
                                .append(this.title)
                                .append(item1)
                                .append(this.ls)
                                .append("------------ Конец вывода --------------")
                                .append(this.ls)
                                .append(this.menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenNotFoundByIdThenOutput() {
        Tracker tracker = new Tracker();
        String id = "someID";
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Поиск заявки по ID --------------")
                                .append(this.ls)
                                .append(String.format("------------ Заявка с Id : %s не найдена --------------", id))
                                .append(this.ls)
                                .append(this.menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByNameThenOutput() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1");
        Item item2 = new Item("name2", "desc2");
        Item item3 = new Item("name2", "desc3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Input input = new StubInput(new String[]{"5", item2.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Поиск заявок по имени --------------")
                                .append(this.ls)
                                .append(this.title)
                                .append(item2)
                                .append(this.ls)
                                .append(item3)
                                .append(this.ls)
                                .append("------------ Конец списка --------------")
                                .append(this.ls)
                                .append(this.menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenNotFoundByNameThenOutput() {
        Tracker tracker = new Tracker();
        String name = "someName";
        Item item1 = new Item("name1", "desc1");
        tracker.add(item1);
        Input input = new StubInput(new String[]{"5", name, "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("------------ Поиск заявок по имени --------------")
                                .append(this.ls)
                                .append(String.format("------------ Не найдено заявок с именем : %s --------------", name))
                                .append(this.ls)
                                .append(this.menu)
                                .toString()
                )
        );
    }
}