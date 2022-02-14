package core.basesyntax.model;

import java.util.Objects;

public class Fruit {

    private String typeOfFruit;

    public Fruit(String typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public void setTypeOfFruit(String typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
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
        return Objects.equals(typeOfFruit, fruit.typeOfFruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfFruit);
    }

    @Override
    public String toString() {
        return typeOfFruit;
    }
}
