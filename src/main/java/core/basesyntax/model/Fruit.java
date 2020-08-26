package core.basesyntax.model;

import java.time.LocalDate;

public class Fruit {
    private String type;
    private int stock_balance;
    private LocalDate date;

    public Fruit(String type, int stock_balance, LocalDate date) {
        this.type = type;
        this.stock_balance = stock_balance;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public int getStock_balance() {
        return stock_balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStock_balance(int stock_balance) {
        this.stock_balance = stock_balance;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        return type != null ? type.equals(fruit.type) : fruit.type == null;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "type='" + type + '\'' +
                ", stock_balance=" + stock_balance +
                ", date=" + date +
                '}';
    }
}
