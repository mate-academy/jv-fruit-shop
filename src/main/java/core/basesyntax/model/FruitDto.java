package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitDto fruitDto = (FruitDto) o;
        return Objects.equals(transaction, fruitDto.transaction)
                && Objects.equals(fruitType, fruitDto.fruitType)
                && quantity == fruitDto.quantity
                && Objects.equals(date, fruitDto.date);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
