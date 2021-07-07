package core.basesyntax;

import java.time.LocalDate;

public class Fruit {
    private String type;
    private int amount;
    private LocalDate date;

    public Fruit(String type, int amount, LocalDate date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
