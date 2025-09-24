package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.isp.menu.output.StubOutput;
import static org.assertj.core.api.Assertions.*;

class PrinterTest {
    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);

        StubOutput stubOutput = new StubOutput();
        Printer printer = new Printer(stubOutput);
        printer.print(menu);
        String ls = System.lineSeparator();
        assertThat(stubOutput.toString()).hasToString("1.Сходить в магазин" + ls
                + "\t1.1.Купить продукты" + ls
                + "\t\t1.1.1.Купить хлеб" + ls
                + "\t\t1.1.2.Купить молоко" + ls
                + "2.Покормить собаку" + ls);
    }
}