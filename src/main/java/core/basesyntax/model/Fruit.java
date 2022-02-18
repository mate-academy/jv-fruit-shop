package core.basesyntax.model;

public class Fruit {
    private String fruitName;
    private int quantity;

    public Fruit(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Fruit(String fruitName) {
        this(fruitName,0);
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return quantity == fruit.quantity
                && fruitName == fruit.fruitName || fruitName != null
                && fruitName.equals(fruit.fruitName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result *= 31 + (fruitName == null ? 0 : fruitName.hashCode());
        result *= 31 + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "Fruit{"
                +
                "fruitName='" + fruitName + '\''
                +
                ", quantity=" + quantity
                +
                '}';
    }
}
