package core.basesyntax.model;

import core.basesyntax.exceptions.OverPurchaseException;
import core.basesyntax.exceptions.WrongNameException;
import core.basesyntax.exceptions.WrongQuantityException;
import java.util.Objects;

public class Fruit {
    private static final String FRUIT_NAME_REGEX = "([a-z]+([-\\s]?[a-z]+))";
    private final String name;
    private int quantity;

    public Fruit(String name, int quantity) {
        if (!name.matches(FRUIT_NAME_REGEX)) {
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

    // If purchase is bigger than fruit quantity, we throw exception
    public void subtract(int quantity) {
        if (this.quantity < quantity) {
            throw new OverPurchaseException(this);
        }
        this.quantity -= quantity;
    }

    // Check if fruits are the same by their name
    // Quantity doesn't matter here
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
        return Objects.hash(name);
    }

    public String toString() {
        return name + ',' + quantity;
    }
}
