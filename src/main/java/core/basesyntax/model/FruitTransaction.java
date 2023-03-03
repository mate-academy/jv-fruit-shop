package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    public static final String BALANCE_MARKER = "b";
    public static final String SUPPLY_MARKER = "s";
    public static final String RETURN_MARKER = "r";
    public static final String PURCHASE_MARKER = "p";
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object fruitTransaction) {
        if (this == fruitTransaction) {
            return true;
        }
        if (fruitTransaction == null || getClass() != fruitTransaction.getClass()) {
            return false;
        }

        FruitTransaction trans = (FruitTransaction) fruitTransaction;
        return Objects.equals(getOperation(), trans.getOperation())
                && Objects.equals(getFruit(), trans.getFruit())
                && getQuantity() == trans.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperation(), getFruit(), getQuantity());
    }

    public enum Operation {
        BALANCE(BALANCE_MARKER),
        SUPPLY(SUPPLY_MARKER),
        PURCHASE(PURCHASE_MARKER),
        RETURN(RETURN_MARKER);

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static FruitTransaction.Operation getOperationLetter(String letter) {
            for (Operation value : Operation.values()) {
                if (value.operation.equals(letter)) {
                    return value;
                }
            }
            throw new RuntimeException("Wrong operation type");
        }
    }
}
