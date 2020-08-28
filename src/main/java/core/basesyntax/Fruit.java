package core.basesyntax;

import java.time.LocalDate;

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
}
