package core.basesyntax.model;

public class Fruit {
    private String fruitName;
    private int quantity;

    public Fruit() {
    }

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public Fruit(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public boolean equals(Object fruit) {
        if (this == fruit) {
            return true;
        }
        if (fruit == null || getClass() != fruit.getClass()) {
            return false;
        }

        Fruit frt = (Fruit) fruit;
        return (frt.fruitName == this.fruitName
                || (frt.fruitName != null && frt.fruitName.equals(this.fruitName)))
                && frt.quantity == this.quantity;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + (fruitName == null ? 0 : fruitName.hashCode());
        result = 31 * result + quantity;
        return result;
    }
}
