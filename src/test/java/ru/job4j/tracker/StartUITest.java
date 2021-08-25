package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
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
        UserAction[] actions = {
                new ExitAction()
        };
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
        UserAction[] actions = {
                new ExitAction(), new ShowAllAction(out)
        };
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
        UserAction[] actions = {
                new ExitAction(), new ShowAllAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + item.toString() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()));
    }
    @Test
    public void whenFindByNameEmpty() {
        Output out = new StubOutput();
        String name = "new item";
        Input in = new StubInput(
                new String[] {"1", "new item", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(), new FindByNameAction(out)
        };
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
        Input in = new StubInput(
                new String[] {"1", "new item", "0"}
        );
        Item item = new Item("new item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        UserAction[] actions = {
                new ExitAction(), new FindByNameAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find by name" + System.lineSeparator()
                + "=== Find item by name ===" + System.lineSeparator()
                + item.toString() + System.lineSeparator()
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
        UserAction[] actions = {
                new ExitAction(), new FindByIdAction(out)
        };
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
        Input in = new StubInput(
                new String[] {"1", "1", "0"}
        );
        Item item = new Item("new item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        UserAction[] actions = {
                new ExitAction(), new FindByIdAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find item by id" + System.lineSeparator()
                + "=== Find item by id ===" + System.lineSeparator()
                + item.toString() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()
                + "1. Find item by id" + System.lineSeparator()));
    }
}