package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String typeOfFruit;
    private int quantity;

    public Fruit(String typeOfFruit, int quantity) {
        this.typeOfFruit = typeOfFruit;
        this.quantity = quantity;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public void setTypeOfFruit(String typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return quantity == fruit.quantity && Objects.equals(typeOfFruit, fruit.typeOfFruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfFruit, quantity);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "typeOfFruit='" + typeOfFruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
