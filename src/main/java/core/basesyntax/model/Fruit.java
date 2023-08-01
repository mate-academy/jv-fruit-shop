package core.basesyntax.model;

public class Fruit {
    private final String fruitName;
    private int quantity;

    public Fruit(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void supplyFruit(int quantity) {
        this.quantity += quantity;
    }

    public void purchaseFruit(int quantity) {
        this.quantity -= quantity;
    }

    public void returnFruit(int quantity) {
        supplyFruit(quantity);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fruitName='" + fruitName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        if (quantity != fruit.quantity) return false;
        return fruitName.equals(fruit.fruitName);
    }

    @Override
    public int hashCode() {
        int result = fruitName.hashCode();
        result = 31 * result + quantity;
        return result;
    }
}
