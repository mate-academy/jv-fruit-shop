package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {

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

        public static Operation parse(String operation) {
            return Arrays.stream(values())
                    .filter(value -> value.getOperation().equals(operation))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No such operation: " + operation));
        }
    }
}
