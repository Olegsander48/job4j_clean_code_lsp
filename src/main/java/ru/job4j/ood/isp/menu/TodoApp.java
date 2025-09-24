package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.output.ConsoleOutput;

import java.util.Scanner;

public class TodoApp {
    static final ActionDelegate DEFAULT_ACTION = () -> System.out.println("Some action");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new SimpleMenu();

        System.out.println("Добро пожаловать в TODO app");
        int answer = 0;
        while (answer != 5) {
            System.out.println("============================================");
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить элемент в корень меню");
            System.out.println("2. Добавить элемент в родителю");
            System.out.println("3. Вызвать действие, привязанное к пункту меню");
            System.out.println("4. Вывести меню в консоль");
            System.out.println("5. Выход");
            answer = scanner.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("Введите имя элемента:");
                    String parentName = scanner.next();
                    menu.add(Menu.ROOT, parentName, DEFAULT_ACTION);
                    break;
                case 2:
                    System.out.println("Введите имя элемента родителя:");
                    parentName = scanner.next();
                    System.out.println("Введите имя дочернего элемента:");
                    String childName = scanner.next();
                    menu.add(parentName, childName, DEFAULT_ACTION);
                    break;
                case 3:
                    System.out.println("Введите имя элемента:");
                    parentName = scanner.next();
                    menu.select(parentName).get().getActionDelegate().delegate();
                    break;
                case 4:
                    Printer printer = new Printer(new ConsoleOutput());
                    printer.print(menu);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Выберите пункт меню и введите его номер");
            }
        }
    }
}
