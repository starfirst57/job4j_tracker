package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void max5And3() {
        int first = 5;
        int second = 3;
        int expected = 5;
        int real = Max.max(5, 3);
        Assert.assertEquals(expected, real);
    }

    @Test
    public void max6And5And1() {
        int first = 6;
        int second = 5;
        int third = 1;
        int expected = 6;
        int real = Max.max(6, 5, 1);
        Assert.assertEquals(expected, real);
    }

}