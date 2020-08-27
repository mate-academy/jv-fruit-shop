package core.basesyntax.model;

import java.time.LocalDate;

public class FruitDto {
    String transaction;
    String fruitType;
    int quantity;
    LocalDate date;

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
