package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private char type;
    private String name;
    private int amount;

    public Fruit(char type, String name, int amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return type == fruit.type && amount == fruit.amount && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, amount);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "type="
                + type
                + ", name='"
                + name
                + '\''
                + ", amount="
                + amount
                + '}';
    }
}
