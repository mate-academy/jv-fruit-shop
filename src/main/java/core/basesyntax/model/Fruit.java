package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String fruitName;
    private int amount;

    public Fruit(String fruitName, int amount) {
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getAmount() {
        return amount;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fruit)) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return getAmount() == fruit.getAmount()
                && Objects.equals(getFruitName(), fruit.getFruitName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFruitName(), getAmount());
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "fruitName='" + fruitName + '\''
                + ", amount=" + amount
                + '}';
    }
}
