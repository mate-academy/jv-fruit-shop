package core.basesyntax.service;

import java.util.Arrays;

public class FruitTransaction {
    public static Operation getOperation(String operation) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getOperation().equals(operation))
                .findFirst().get();
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
}
