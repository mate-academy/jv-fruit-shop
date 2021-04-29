package model;

import java.util.Objects;

public class Fruit {
    private String fruitType;

    public Fruit(String fruitType) {
        this.fruitType = fruitType;
    }

    public String getFruitType() {
        return fruitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fruit)) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return Objects.equals(fruitType, fruit.fruitType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitType);
    }
}
