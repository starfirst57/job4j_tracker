package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Profile> list = Arrays.asList(
                new Profile(new Address("NSK", "Krasnaya", "33", "4")),
                new Profile(new Address("MSK", "Arbat", "14", "2")));
        List<Address> real = Profiles.collect(list);
        List<Address> expected = Arrays.asList(
                new Address("MSK", "Arbat", "14", "2"),
                new Address("NSK", "Krasnaya", "33", "4")
        );
        assertEquals(real, expected);
    }

    @Test
    public void whenDuplicate() {
        List<Profile> list = Arrays.asList(
                new Profile(new Address("NSK", "Krasnaya", "33", "4")),
                new Profile(new Address("NSK", "Krasnaya", "33", "4")));
        List<Address> real = Profiles.collect(list);
        List<Address> expected = Arrays.asList(
                new Address("NSK", "Krasnaya", "33", "4")
        );
        assertEquals(real, expected);
    }
}