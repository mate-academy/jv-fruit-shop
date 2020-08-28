package core.basesyntax.maketransaction;

import java.util.Objects;

public class Transaction {
    private String type;
    private String fruit;
    private int quantity;
    private String date;

    public Transaction() {
    }

    public Transaction(String type, String fruit, int quantity, String date) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return quantity == that.quantity
                && Objects.equals(type, that.type)
                && Objects.equals(fruit, that.fruit)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, quantity, date);
    }
}
