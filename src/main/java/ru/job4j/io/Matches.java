package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 11;
        int turn = 1;
        int choice = 0;
        do {
            System.out.println("Ход номер " + turn);
            if (turn % 2 != 0) {
                System.out.println("Первый игрок, введите число от 1 до 3");
            } else {
                System.out.println("Второй игрок, введите число от 1 до 3");
            }
            choice = Integer.parseInt(input.nextLine());
            if (choice > 0 && choice <= 3) {
                count -= choice;
                turn++;
                System.out.println("Спичек осталось: " + count);
            } else {
                System.out.println("Некорректное число");
            }
        } while (count > 0);
        if (turn % 2 == 0) {
            System.out.println("Выйграл первый игрок");
        } else {
            System.out.println("Выйграл второй игрок");
        }
    }
}
