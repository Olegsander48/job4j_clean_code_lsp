package ru.job4j.ood.isp.menu;

public class Printer implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        menu.forEach(System.out::println);
    }
}
