package core.basesyntax.model;

import java.util.Objects;

public class FruitData {
    private final String fruitName;
    private int quantity;

    public FruitData(String fruit, int quantity) {
        this.fruitName = fruit;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "FruitDao{" + "fruit='" + fruitName + '\''
                + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FruitData)) {
            return false;
        }
        FruitData fruitData1 = (FruitData) o;
        return getQuantity() == fruitData1.getQuantity() && Objects.equals(getFruitName(),
                fruitData1.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFruitName(), getQuantity());
    }
}
