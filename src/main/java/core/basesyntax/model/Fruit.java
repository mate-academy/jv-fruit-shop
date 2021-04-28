package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private final String name;
    private long quantity;

    public Fruit(String fruitName, long quantity) {
        this.name = fruitName;
        this.quantity = quantity;
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
        return name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Fruit{" + "name='" + name + '\''
                + ", quantity=" + quantity + '}';
    }

    public String getName() {
        return name;
    }

    public void setBalance(long quantity) {
        this.quantity = quantity;
    }

    public long getBalance() {
        return quantity;
    }
}
