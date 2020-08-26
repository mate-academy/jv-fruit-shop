package core.basesyntax.products;

import java.time.LocalDate;

public class Fruit {
    private String name;
    private int amount;
    private LocalDate date;

    public Fruit(String name, int amount, LocalDate date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}


