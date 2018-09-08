package ru.job4j.fit;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitTest {

    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double result = fit.manWeight(180);
        double expected = 92.0;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double result = fit.womanWeight(170);
        double expected = 69.0;
        assertThat(result, closeTo(expected, 0.1));
    }
}