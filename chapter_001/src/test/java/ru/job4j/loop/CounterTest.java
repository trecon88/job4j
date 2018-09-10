package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CounterTest {
    @Test
    public void whenStart0End10Then30() {
        Counter counter = new Counter();
        int start = 0;
        int finish = 10;

        int result = counter.add(start, finish);
        int expected = 30;

        assertThat(result, is(expected));
    }
}