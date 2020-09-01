package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String typeOfFruit;
    private String expirationDate;

    public Fruit(String typeOfFruit, String expirationDate) {
        this.typeOfFruit = typeOfFruit;
        this.expirationDate = expirationDate;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public String getExpirationDate() {
        return expirationDate;
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
        return Objects.equals(typeOfFruit, fruit.typeOfFruit)
                && Objects.equals(expirationDate, fruit.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfFruit, expirationDate);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "typeOfFruit='" + typeOfFruit + '\''
                + ", expirationDate='" + expirationDate + '\''
                + '}';
    }
}
