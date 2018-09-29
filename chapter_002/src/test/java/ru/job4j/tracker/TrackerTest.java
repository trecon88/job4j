package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenReplaceNotFoundThenReturnSourceName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.replace("someId", next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test1"));
    }

    /**
     * Не предумал как по другому проверить удаление элемента.
     */
    @Test
    public void whenDeleteThenDeleted() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 1L);
        Item item2 = new Item("test2", "testDescription2", 2L);
        Item item3 = new Item("test3", "testDescription3", 3L);
        Item item4 = new Item("test4", "testDescription4", 4L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(item2.getId());
        Item[] result = tracker.findAll();
        Item[] expected = {item1, item3, item4};
        assertThat(result, is(expected));
    }
    @Test
    public void whenWrongIdThenNothingDeleted() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 1L);
        Item item2 = new Item("test2", "testDescription2", 2L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete("someId");
        Item[] result = tracker.findAll();
        Item[] expected = {item1, item2};
        assertThat(result, is(expected));
    }
    @Test
    public void whenFindAllThenArrayWithoutNulls() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 1L);
        Item item2 = new Item("test2", "testDescription2", 2L);
        Item item3 = new Item("test3", "testDescription3", 3L);
        Item item4 = new Item("test4", "testDescription4", 4L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] result = tracker.findAll();
        Item[] expected = {item1, item2, item3, item4};
        assertThat(result, is(expected));
    }
    @Test
    public void whenFindAllInEmptyThenNull() {
        Tracker tracker = new Tracker();
        Item[] result = tracker.findAll();
        Item[] expected = null;
        assertThat(result, is(expected));
    }
    @Test
    public void whenFindByNameThenArrayOfItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 1L);
        Item item2 = new Item("test2", "testDescription2", 2L);
        Item item3 = new Item("test1", "testDescription3", 3L);
        Item item4 = new Item("test4", "testDescription4", 4L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] result = tracker.findByName(item1.getName());
        Item[] expected = {item1, item3};
        assertThat(result, is(expected));
    }
    @Test
    public void whenNotFindByNameThenNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 1L);
        Item item2 = new Item("test2", "testDescription2", 2L);
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = tracker.findByName("someName");
        Item[] expected = null;
        assertThat(result, is(expected));
    }
}