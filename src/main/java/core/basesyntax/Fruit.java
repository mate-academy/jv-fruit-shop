package core.basesyntax;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit {
    private String fruitName;
    private LocalDate expirationDate;

    public Fruit(String fruitName, LocalDate expirationDate) {
        this.fruitName = fruitName;
        this.expirationDate = expirationDate;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
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
        return Objects.equals(fruitName, fruit.fruitName)
                && Objects.equals(expirationDate, fruit.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, expirationDate);
    }
}
