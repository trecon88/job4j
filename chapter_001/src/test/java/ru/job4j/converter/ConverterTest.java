package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDollarTo60RubleThen1() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        int expected = 60;
        assertThat(result, is(expected));
    }

    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void whenEuroTo70RubleThen1() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        int expected = 70;
        assertThat(result, is(expected));
    }

}