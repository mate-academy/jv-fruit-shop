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
    public boolean equals(Object fruit) {
        if (this == fruit) {
            return true;
        }
        if (!(fruit instanceof Fruit)) {
            return false;
        }
        Fruit thatFruit = (Fruit) fruit;
        return Objects.equals(typeOfFruit, thatFruit.typeOfFruit);
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
