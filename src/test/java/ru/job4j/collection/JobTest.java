package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SortASC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void sortAscByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("a", 2));
        jobs.add(new Job("c", 4));
        jobs.add(new Job("d", 3));
        jobs.add(new Job("b", 1));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("a", 2));
        expected.add(new Job("b", 1));
        expected.add(new Job("c", 4));
        expected.add(new Job("d", 3));
        jobs.sort(new SortAscByName());
        assertEquals(expected, jobs);
    }

    @Test
    public void sortDescByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("a", 2));
        jobs.add(new Job("c", 4));
        jobs.add(new Job("d", 3));
        jobs.add(new Job("b", 1));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("d", 3));
        expected.add(new Job("c", 4));
        expected.add(new Job("b", 1));
        expected.add(new Job("a", 2));
        jobs.sort(new SortDescByName());
        assertEquals(expected, jobs);
    }

    @Test
    public void sortAscByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("a", 2));
        jobs.add(new Job("c", 4));
        jobs.add(new Job("d", 3));
        jobs.add(new Job("b", 1));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("b", 1));
        expected.add(new Job("a", 2));
        expected.add(new Job("d", 3));
        expected.add(new Job("c", 4));
        jobs.sort(new SortAscByPriority());
        assertEquals(expected, jobs);
    }

    @Test
    public void sortDescByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("a", 2));
        jobs.add(new Job("c", 4));
        jobs.add(new Job("d", 3));
        jobs.add(new Job("b", 1));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("c", 4));
        expected.add(new Job("d", 3));
        expected.add(new Job("a", 2));
        expected.add(new Job("b", 1));
        jobs.sort(new SortDescByPriority());
        assertEquals(expected, jobs);
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new SortDescByName().thenComparing(new SortDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityAndName() {
        Comparator<Job> cmpNamePriority = new SortAscByPriority().thenComparing(new SortAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}