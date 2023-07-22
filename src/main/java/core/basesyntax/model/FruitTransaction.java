package core.basesyntax.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

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
        if (fruitTransaction == null) {
            return false;
        }
        if (fruitTransaction.getClass().equals(this.getClass())) {
            FruitTransaction realFruitTransaction = (FruitTransaction) fruitTransaction;
            return realFruitTransaction.getFruit().equals(this.fruit)
                    && realFruitTransaction.getQuantity() == this.quantity
                    && realFruitTransaction.getOperation().equals(this.operation);
        }
        return false;
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

        public String getCode() {
            return code;
        }

        public static String getAllAllowedOperationTypes() {
            return Arrays.stream(values())
                    .map(Operation::getCode)
                    .collect(Collectors.joining(", "));
        }
    }
}
