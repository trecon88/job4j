package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        BubbleSort bubbleSort = new  BubbleSort();
        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        //int[] array = {2, 1, 0};
        int[] result = bubbleSort.sort(array);
        int[] expexted = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        //int[] expexted = {0, 1, 2};
        assertThat(result, is(expexted));
    }
}