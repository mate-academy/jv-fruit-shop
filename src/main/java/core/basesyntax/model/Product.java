package core.basesyntax.model;

import java.util.Objects;

public final class Product {
    private final String fruitName;

    public Product(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
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
        return Objects.equals(fruitName, fruit.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName);
    }

    @Override
    public String toString() {
        return "Fruit{" + "fruitName='" + fruitName + '\'' + '}';
    }
}
