package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 500);
        Book second = new Book("Harry Potter", 250);
        Book third = new Book("Green mile", 100);
        Book fourth = new Book("Physics", 400);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " " + books[index].getPages());
        }
        books[3] = first;
        books[0] = fourth;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " " + books[index].getPages());
        }
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName());
            }
        }
    }
}
