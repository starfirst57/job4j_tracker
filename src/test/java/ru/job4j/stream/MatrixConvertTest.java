package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MatrixConvertTest {

    @Test
    public void convert() {
        MatrixConvert conv = new MatrixConvert();
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> real = conv.convert(matrix);
        assertEquals(expected, real);
    }
}