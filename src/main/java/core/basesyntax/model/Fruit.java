package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String fruitName;

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return Objects.equals(getFruitName(), fruit.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFruitName());
    }
}
