package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String fruitName;
    private int amount;

    public Fruit() {
    }

    public Fruit(String fruitName, int amount) {
        this.fruitName = fruitName;
        this.amount = amount;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "fruitName='" + fruitName + '\''
                + ", amount=" + amount
                + '}';
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
        return amount == fruit.amount
                && Objects.equals(fruitName, fruit.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, amount);
    }

}
