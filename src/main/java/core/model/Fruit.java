package core.model;

import java.util.Objects;

public class Fruit {
    private String fruit;

    public Fruit(String fruit) {
        this.fruit = fruit;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
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
        return Objects.equals(fruit, fruit1.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit);
    }

    @Override
    public String toString() {
        return fruit;
    }
}
