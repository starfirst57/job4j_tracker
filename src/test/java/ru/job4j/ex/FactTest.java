package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenException() {
        new Fact().calc(-1);
    }

    @Test
    public void whenNoException() {
        int expected = 6;
        int real = new Fact().calc(3);
        Assert.assertEquals(expected, real);
    }
}