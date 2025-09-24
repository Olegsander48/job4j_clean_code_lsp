package ru.job4j.ood.isp.menu;

public class Printer implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        menu.forEach(i ->
            System.out.println("\t".repeat(i.getNumber().length() / 2 - 1) +  i.getNumber() + i.getName())
        );
    }
}
