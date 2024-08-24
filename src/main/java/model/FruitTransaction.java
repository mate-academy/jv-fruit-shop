package model;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return getOperation() == that.getOperation() && Objects.equals(getFruit(), that.getFruit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperation(), getFruit());
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

        public String getCode() {
            return code;
        }

        public static Operation parseOperation(String code) {
            return Arrays.stream(FruitTransaction.Operation.values())
                    .filter(o -> o.getCode().equals(code))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid operation name: "
                            + code + ". Must be one of these "
                            + Arrays.stream(Operation.values())
                            .map(Operation::getCode)
                            .collect(Collectors.joining(",", "{", "}"))));
        }
    }
}
