package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when01To22Then2Dot23() {
        Point first = new Point(0, 1);
        Point second = new Point(2, 2);
        double expected = 2.23;
        double out = first.distance3d(second);
        double esp = 0.01;
        Assert.assertEquals(expected, out, esp);
    }

    @Test
    public void when53To36Then3Dot6() {
        Point first = new Point(5, 3);
        Point second = new Point(3, 6);
        double expected = 3.6;
        double out = first.distance3d(second);
        double esp = 0.01;
        Assert.assertEquals(expected, out, esp);
    }

    @Test
    public void when00To22Then2Dot82() {
        Point first = new Point(0, 0);
        Point second = new Point(2, 2);
        double expected = 2.82;
        double out = first.distance3d(second);
        double esp = 0.01;
        Assert.assertEquals(expected, out, esp);
    }

    @Test
    public void when001To222Then3() {
        Point first = new Point(0, 0, 1);
        Point second = new Point(2, 2, 2);
        double expected = 3;
        double out = first.distance3d(second);
        double esp = 0.01;
        Assert.assertEquals(expected, out, esp);
    }

    @Test
    public void when101To232Then3() {
        Point first = new Point(1, 0, 1);
        Point second = new Point(2, 3, 2);
        double expected = 3.31;
        double out = first.distance3d(second);
        double esp = 0.01;
        Assert.assertEquals(expected, out, esp);
    }
}