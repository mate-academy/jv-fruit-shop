package core.basesyntax.model;

import core.basesyntax.exeption.NoSuchOperationException;
import java.util.Objects;
import java.util.stream.Stream;

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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        FruitTransaction fruitTransaction = (FruitTransaction) obj;
        return operation == fruitTransaction.operation
                && quantity == fruitTransaction.quantity
                && Objects.equals(fruit, fruitTransaction.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity);
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

        public static Operation getOperation(String operationCode) {
            return Stream.of(FruitTransaction.Operation.values())
                    .filter(operation -> operation.getCode().equals(operationCode))
                    .findFirst()
                    .orElseThrow(() ->
                            new NoSuchOperationException("No such operation by code: "
                                    + operationCode));
        }
    }
}
