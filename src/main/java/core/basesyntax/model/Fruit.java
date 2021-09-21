package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    String fruitName;

    public void setFruit(String fruit) {
        this.fruitName = fruit;
    }

    public String getFruit() {
        return fruitName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit1 = (Fruit) o;
        return Objects.equals(fruitName, fruit1.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName);
    }
}
