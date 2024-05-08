package model;

import exception.FruitShopException;
import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction() {
    }

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public FruitTransaction(String operation, String fruit, String quantity) {
        this.operation = Operation.fromCode(operation.trim());
        this.fruit = fruit.trim();
        this.quantity = Integer.parseInt(quantity.trim());
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");
        private final String code;

        Operation(String code) {
            this.code = code;
        }

        String get() {
            return this.code;
        }

        public static Operation fromCode(String code) {
            switch (code) {
                case "b":
                    return BALANCE;
                case "s":
                    return SUPPLY;
                case "p":
                    return PURCHASE;
                case "r":
                    return RETURN;
                default:
                    throw new FruitShopException("Operation not found");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return quantity == that.quantity
                && operation == that.operation
                && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity);
    }
}
