package core.basesyntax.models;

import java.util.Objects;

public class FruitTransition {
    private Operation operation;
    private Fruit.Type fruitType;
    private int fruitAmount;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruitType(Fruit.Type fruitType) {
        this.fruitType = fruitType;
    }

    public void setFruitAmount(int fruitAmount) {
        this.fruitAmount = fruitAmount;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit.Type getFruitType() {
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
        FruitTransition that = (FruitTransition) o;
        return fruitAmount == that.fruitAmount && operation == that.operation
                && fruitType == that.fruitType;
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

        public String getCode() {
            return code;
        }

        public static Operation setCode(String code) {
            for (Operation operation : values()) {
                if (operation.code.equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No enum constant with code: " + code);
        }
    }
}
