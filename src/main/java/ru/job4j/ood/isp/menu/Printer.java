package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.output.Output;

public class Printer implements MenuPrinter {
    private final Output output;

    public Printer(Output output) {
        this.output = output;
    }

    @Override
    public void print(Menu menu) {
        menu.forEach(i ->
            output.println("\t".repeat(i.getNumber().length() / 2 - 1) +  i.getNumber() + i.getName())
        );
    }
}
