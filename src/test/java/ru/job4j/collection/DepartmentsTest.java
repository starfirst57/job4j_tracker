package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void  sortAsc() {
        List<String> list = Arrays.asList("K1/SK1", "K1",
                "K1/SK1/SSK2", "K1/SK2", "K1/SK1/SSK1",
                "K2/SK1", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2");
        Departments.sortAsc(list);
        List<String> expected = List.of("K1", "K1/SK1", "K1/SK1/SSK1",
                "K1/SK1/SSK2", "K1/SK2", "K2",
                "K2/SK1", "K2/SK1/SSK1",
                "K2/SK1/SSK2");
        assertEquals(expected, list);
    }

    @Test
    public void  sortDesc() {
        List<String> list = Arrays.asList("K1/SK1", "K1",
                "K1/SK1/SSK2", "K1/SK2", "K1/SK1/SSK1",
                "K2/SK1", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2");
        Departments.sortDesc(list);
        List<String> expected = List.of("K2",
                "K2/SK1", "K2/SK1/SSK1",
                "K2/SK1/SSK2", "K1", "K1/SK1", "K1/SK1/SSK1",
                "K1/SK1/SSK2", "K1/SK2");
        assertEquals(expected, list);
    }
}