package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private final String fruitName;
    private int quantity;
    private Operation operation;

    public FruitTransaction(Operation operation, String fruitName, int fruitCount) {
        this.fruitName = fruitName;
        this.quantity = fruitCount;
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public enum Operation {

        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation getByCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.getOperation().equals(code)) {
                    return operation;
                }
            }
            throw new RuntimeException("code operation does not found");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FruitTransaction)) {
            return false;
        }

        FruitTransaction that = (FruitTransaction) o;

        if (quantity != that.quantity) {
            return false;
        }
        if (fruitName != null ? fruitName.equals(that.fruitName) : that.fruitName == null) {
            return operation == that.operation;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = fruitName != null ? fruitName.hashCode() : 0;
        result = 31 * result + quantity;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }
}

