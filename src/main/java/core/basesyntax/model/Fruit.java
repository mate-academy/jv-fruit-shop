package core.basesyntax.model;

public class Fruit {
    private int quantity;
    private String fruitType;

    public Fruit() {
    }

    public Fruit(String fruitType) {
        this.fruitType = fruitType;
    }

    public Fruit(String fruitType, int quantity) {
        this.fruitType = fruitType;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public boolean equals(Object fruit) {
        if (fruit == this) {
            return true;
        }
        if (fruit == null) {
            return false;
        }
        if (fruit.getClass().equals(Fruit.class)) {
            Fruit newFruit = (Fruit) fruit;
            return (newFruit.fruitType == this.fruitType
                    || (newFruit.fruitType != null && newFruit.fruitType.equals(this.fruitType)))
                   && newFruit.quantity == this.quantity;
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result += 31 + (fruitType == null ? 0 : fruitType.hashCode());
        result += 31 + quantity;
        return result;
    }
}
