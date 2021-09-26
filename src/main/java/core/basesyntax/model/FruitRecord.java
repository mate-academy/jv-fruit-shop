package core.basesyntax.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FruitRecord {
    private final Operation operation;
    private final String fruit;
    private final int amount;

    public FruitRecord(Operation operation, String fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "FruitRecord{"
                + "operation=" + operation
                + ", fruit='" + fruit + '\''
                + ", amount=" + amount + '}';
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private static final Map<String, Operation> types = new HashMap<>();

        static {
            Arrays.stream(values()).forEach(operation -> types.put(operation.getType(), operation));
        }

        private final String type;

        Operation(String s) {
            this.type = s;
        }

        public static Operation get(String type) {
            return types.get(type);
        }

        public String getType() {
            return type;
        }
    }
}
