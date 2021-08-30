package shop;

import java.util.Objects;

public class FruitShopOperation {
    private String name;
    private int amount;
    private String operation;

    public FruitShopOperation(String operation, String name, int amount) {
        this.operation = operation;
        this.name = name;
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "operation='"
                + operation
                + '\''
                + ", name='"
                + name
                + '\''
                + ", amount="
                + amount
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
        FruitShopOperation fruit = (FruitShopOperation) o;
        return amount == fruit.amount && Objects.equals(operation, fruit.operation)
                && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, name, amount);
    }
}
