package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit {
    private String typeOfFruit;
    private LocalDate expirationDate;

    public Fruit(String typeOfFruit, LocalDate expirationDate) {
        this.typeOfFruit = typeOfFruit;
        this.expirationDate = expirationDate;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public LocalDate getExpirationDate() {
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
