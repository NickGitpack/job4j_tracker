package ru.job4j.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    public void when22To33Then1d73() {
        double expected = 1.73;
        Point x = new Point(2, 2, 2);
        Point y = new Point(3, 3, 3);
        double out = x.distance3d(y);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when123To456Then5d19() {
        double expected = 5.19;
        Point x = new Point(1, 2, 3);
        Point y = new Point(4, 5, 6);
        double out = x.distance3d(y);
        Assert.assertEquals(expected, out, 0.01);
    }
}