package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String nameOfFruit;

    public Fruit(String nameOfFruit) {
        this.nameOfFruit = nameOfFruit;
    }

    public String getNameOfFruit() {
        return nameOfFruit;
    }

    public void setNameOfFruit(String nameOfFruit) {
        this.nameOfFruit = nameOfFruit;
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
        return Objects.equals(nameOfFruit, fruit.nameOfFruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfFruit);
    }

    @Override
    public String toString() {
        return nameOfFruit;
    }
}
