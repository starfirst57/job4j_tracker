package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllActionEmpty() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(), new ShowAllAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "Хранилище еще не содержит заявок" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllActionHasItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Item item = new Item("new item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        List<UserAction> actions = List.of(new ExitAction(), new ShowAllAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()));
    }
    @Test
    public void whenFindByNameEmpty() {
        Output out = new StubOutput();
        String name = "new item";
        Input in = new StubInput(
                new String[] {"1", name, "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(), new FindByNameAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find by name" + System.lineSeparator()
                + "=== Find item by name ===" + System.lineSeparator()
                + "Заявки с именем: " + name + " не найдены" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find by name" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameActionHasItem() {
        Output out = new StubOutput();
        Item item = new Item("new item");
        Input in = new StubInput(
                new String[] {"1", item.getName(), "0"}
        );
        Tracker tracker = new Tracker();
        tracker.add(item);
        List<UserAction> actions = List.of(new ExitAction(), new FindByNameAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find by name" + System.lineSeparator()
                + "=== Find item by name ===" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find by name" + System.lineSeparator()));
    }

    @Test
    public void whenFindByIdEmpty() {
        Output out = new StubOutput();
        String id = "1";
        Input in = new StubInput(
                new String[] {"1", id, "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(),
                new FindByIdAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find item by id" + System.lineSeparator()
                + "=== Find item by id ===" + System.lineSeparator()
                + "Заявка с данным id: " + id + " не найдена" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find item by id" + System.lineSeparator()));
    }

    @Test
    public void whenFindByIdActionHasItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("new item"));
        Input in = new StubInput(
                new String[] {"1", Integer.toString(item.getId()), "0"}
        );
        List<UserAction> actions = List.of(new ExitAction(), new FindByIdAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find item by id" + System.lineSeparator()
                + "=== Find item by id ===" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find item by id" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"20", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu." + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu." + ln
                                + "0. Exit" + ln
                )
        );
    }
}