package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class FruitBox {
    private String fruitType;
    private int quantity;
    private LocalDate date;
    private boolean isEmpty;

    public FruitBox(String fruitType, int quantity, LocalDate date, boolean isEmpty) {
        this.fruitType = fruitType;
        this.quantity = quantity;
        this.date = date;
        this.isEmpty = isEmpty;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        if (quantity == 0) {
            setEmpty(true);
        }
        if (quantity > 0) {
            setEmpty(false);
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitBox fruitBox = (FruitBox) o;
        return quantity == fruitBox.quantity
                && isEmpty == fruitBox.isEmpty
                && Objects.equals(fruitType, fruitBox.fruitType)
                && Objects.equals(date, fruitBox.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitType, quantity, date, isEmpty);
    }
}
