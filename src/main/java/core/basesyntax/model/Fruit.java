package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;
    private int amount;
    private Type type;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        BALANCE, SUPPLY, PURCHASE, RETURN;
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
        return amount == fruit.amount
                && Objects.equals(name, fruit.name)
                && type == fruit.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, type);
    }
}
