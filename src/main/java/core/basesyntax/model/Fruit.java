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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return Objects.equals(typeOfFruit, typeOfFruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfFruit);
    }
}
