package core.basesyntax.model;

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
}
