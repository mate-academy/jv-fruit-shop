package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String fruitType;
    private LocalDate expirationDate;

    public Product(String fruitType, LocalDate expirationDate) {
        this.fruitType = fruitType;
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getFruitType() {
        return fruitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product fruit = (Product) o;
        return Objects.equals(expirationDate, fruit.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expirationDate);
    }
}
