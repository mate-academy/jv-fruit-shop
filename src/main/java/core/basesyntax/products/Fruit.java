package core.basesyntax.products;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return amount == fruit.amount &&
                Objects.equals(name, fruit.name) &&
                Objects.equals(date, fruit.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, date);
    }
}


