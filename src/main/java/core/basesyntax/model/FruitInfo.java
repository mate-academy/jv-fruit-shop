package core.basesyntax.model;

import java.util.Objects;

public class FruitInfo {
    private FruitType fruitType;
    private int quantity;
    private String activities;

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FruitInfo fruitInfo)) {
            return false;
        }
        return quantity == fruitInfo.quantity && fruitType == fruitInfo.fruitType
                && Objects.equals(activities, fruitInfo.activities);
    }

    @Override
    public String toString() {
        return "FruitInfo{"
                + "fruitType=" + fruitType
                + ", quantity=" + quantity
                + ", activities='"
                + activities + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitType, quantity, activities);

    }
}
