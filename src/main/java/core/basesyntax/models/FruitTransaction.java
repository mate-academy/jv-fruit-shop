package core.basesyntax.models;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitTransaction {
    private FruitTransaction.Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction.Operation getOperation() {
        return operation;
    }

    public void setOperation(FruitTransaction.Operation operation) {
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
    }

    public static Map<String, Operation> createMapFromEnumOperations() {
        return Arrays.stream(Operation.values())
                .collect(Collectors.toMap(Operation::getOperation, operation -> operation));
    }
}
