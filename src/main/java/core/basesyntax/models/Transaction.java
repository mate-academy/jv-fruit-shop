package core.basesyntax.models;

import java.util.Objects;

public class Transaction {
    private String type;
    private String name;
    private Integer quantity;

    public Transaction(String type, String name, Integer quantity) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(type, that.type) && Objects.equals(name, that.name) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, quantity);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                       "type='" + type + '\'' +
                       ", name='" + name + '\'' +
                       ", quantity=" + quantity +
                       '}';
    }
}
