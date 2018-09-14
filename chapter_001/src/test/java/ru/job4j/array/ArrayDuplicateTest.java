package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateFirst() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Привет", "Супер", "Мир", "Привет", "Супер", "Мир"});
        String[] expected = {"Привет", "Супер", "Мир"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateSecond() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Пока", "Привет", "Пока", "Пока", "Пока", "Пока"});
        String[] expected = {"Пока", "Привет"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateThird() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Пока", "Пока", "Пока", "Пока", "Пока", "Пока"});
        String[] expected = {"Пока"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
    @Test
    public void whenNoDuplicatesThenArray() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"1", "2", "3", "4", "5", "6"});
        String[] expected = {"1", "2", "3", "4", "5", "6"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}