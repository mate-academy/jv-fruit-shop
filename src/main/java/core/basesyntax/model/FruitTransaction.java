package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public FruitTransaction setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    public String getFruit() {
        return fruit;
    }

    public FruitTransaction setFruit(String fruit) {
        this.fruit = fruit;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public FruitTransaction setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "FruitTransaction{" +
                "operation=" + operation +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FruitTransaction that = (FruitTransaction) o;

        if (quantity != that.quantity) return false;
        if (operation != that.operation) return false;
        return Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        int result = operation != null ? operation.hashCode() : 0;
        result = 31 * result + (fruit != null ? fruit.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
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

        public static Operation getParamCode(Class<Operation> enumOperation, String code) {
            for (Operation enumVal : enumOperation.getEnumConstants()) {
                if (enumVal != null) {
                    if (enumVal.getCode().equals(code)) {
                        return enumVal;
                    }
                }
            }
            throw new RuntimeException("Unknown parameter code: \"" + code + "\"");
        }
    }
}
