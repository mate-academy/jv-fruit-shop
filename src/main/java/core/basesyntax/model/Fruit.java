package core.basesyntax.model;

import java.util.Objects;

public final class Fruit {
    private final String name;
    private final long amount;

    public Fruit(String fruitName, long amount) {
        this.name = fruitName;
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
        return name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Fruit{" + "name='" + name + '\''
                + ", amount=" + amount + '}';
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return amount;
    }

    public Fruit setAmount(long amount) {
        return new Fruit(name, amount);
    }
}
