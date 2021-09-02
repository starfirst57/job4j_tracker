package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("medium", 2));
        queue.put(new Task("low", 3));
        queue.put(new Task("high", 1));
        queue.put(new Task("low", 5));
        for (Task element: queue.tasks) {
            System.out.println(element.getPriority() + " " + element.getDesc());
        }
    }
}

