package shop;

import java.util.Objects;

public class FruitShopOperation {
    private Fruit fruit;
    private int amount;
    private String operation;

    public FruitShopOperation(String operation, Fruit fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public int getAmount() {
        return amount;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "FruitShopOperation{"
                + "fruit="
                + fruit
                + ", amount="
                + amount
                + ", operation='"
                + operation
                + '\''
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
        FruitShopOperation that = (FruitShopOperation) o;
        return amount == that.amount && Objects.equals(fruit, that.fruit)
                && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit, amount, operation);
    }
}
