package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
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

        public static Operation getByCharacter(String ch) {
            return Arrays.stream(values())
                    .filter(operation -> operation.getOperation().equals(ch))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No such operation exists: " + ch));
        }

        public String getOperation() {
            return operation;
        }
    }
}
