package core.basesyntax.model;

import core.basesyntax.exceptions.WrongNameException;
import core.basesyntax.exceptions.WrongQuantityException;
import java.util.Objects;

public class Fruit {
    private final String name;
    private int quantity;

    public Fruit(String name, int quantity) {
        if (!name.matches("([a-z]+([-\\s]?[a-z]+))")) {
            throw new WrongNameException();
        }
        this.name = name;
        if (quantity <= 0) {
            throw new WrongQuantityException();
        }
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }

    public void subtract(int quantity) {
        this.quantity -= quantity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) object;
        return name.equals(fruit.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }

    public String toString() {
        return name + ',' + quantity;
    }
}
