package core.basesyntax.models;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruitType;
    private int fruitAmount;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public void setFruitAmount(int fruitAmount) {
        this.fruitAmount = fruitAmount;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getFruitAmount() {
        return fruitAmount;
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
        return fruitAmount == that.fruitAmount && operation == that.operation
                && fruitType.equals(that.fruitType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruitType, fruitAmount);
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

        public String getOperation() {
            return code;
        }

        public static Operation getOperation(String code) {
            for (Operation operation : values()) {
                if (operation.code.equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No enum constant with code: " + code);
        }
    }
}
