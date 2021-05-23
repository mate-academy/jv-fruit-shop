package core.basesyntax.model;

import java.util.Objects;

public final class Product {
    private final String name;

    public Product(String fruitName) {
        this.name = fruitName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherFruit) {
        if (this == otherFruit) {
            return true;
        }
        if (otherFruit == null || getClass() != otherFruit.getClass()) {
            return false;
        }
        Product fruit = (Product) otherFruit;
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Fruit{" + "fruitName='" + name + '\'' + '}';
    }
}
