package app.model;

import java.time.LocalDate;
import java.util.Objects;

public class SupplyFruit {
    private String fruitName;
    private int quantity;
    private LocalDate endOfShelfLife;

    public SupplyFruit(String fruitName, int quantity, LocalDate endOfShelfLife) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.endOfShelfLife = endOfShelfLife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SupplyFruit)) {
            return false;
        }
        SupplyFruit fruit = (SupplyFruit) o;
        return getQuantity() == fruit.getQuantity()
                && Objects.equals(getFruitName(), fruit.getFruitName())
                && Objects.equals(getEndOfShelfLife(), fruit.getEndOfShelfLife());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFruitName(), getQuantity(), getEndOfShelfLife());
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getEndOfShelfLife() {
        return endOfShelfLife;
    }

}
