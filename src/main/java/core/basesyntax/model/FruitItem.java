package core.basesyntax.model;

import java.util.Objects;

public class FruitItem {
    private String fruitName;
    private int fruitQuantity;

    public FruitItem(String fruitName, int fruitQuantity) {
        this.fruitName = fruitName;
        this.fruitQuantity = fruitQuantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FruitItem fruitItem)) return false;
        return getFruitQuantity() == fruitItem.getFruitQuantity() && Objects.equals(getFruitName(), fruitItem.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFruitName(), getFruitQuantity());
    }
}
