package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private String fruitName;
    private int quantity;
    private Operation operation;

    public FruitTransaction(String fruitName, int quantity, Operation operation) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.code.equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No enum constant with code: " + code);
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
        return quantity == that.quantity && Objects.equals(fruitName, that.fruitName)
                && operation == that.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, quantity, operation);
    }
}
