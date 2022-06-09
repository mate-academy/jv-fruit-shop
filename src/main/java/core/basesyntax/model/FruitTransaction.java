package core.basesyntax.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitTransaction {
    private final Operation operation;
    private final Fruit fruit;

    public FruitTransaction(Operation operation, Fruit fruit) {
        this.operation = operation;
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private static final Map<String, Operation> LOOKUP_MAP;

        static {
            LOOKUP_MAP = Arrays.stream(Operation.values())
                    .collect(Collectors.toMap(Operation::getOperation, Function.identity()));
        }

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation retrieveByOperation(String operation) {
            if (operation == null) {
                throw new RuntimeException("Fruit operation cannot be null");
            }
            if (LOOKUP_MAP.get(operation) == null) {
                throw new IllegalArgumentException("No such fruit operation type: " + operation);
            }
            return LOOKUP_MAP.get(operation);
        }
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
        return operation == that.operation && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit);
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruit=" + fruit + '}';
    }
}
