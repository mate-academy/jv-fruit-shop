package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitTransaction extends Fruit {
    private Operation operation;

    public FruitTransaction(String name, int quantity, Operation operation) {
        super(name, quantity);
        this.operation = operation;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private static final Map<String, Operation> BY_LABEL = new HashMap<>();

        static {
            for (Operation o : values()) {
                BY_LABEL.put(o.operation, o);
            }
        }

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }   

        public static Operation valueOfLabel(String label) {
            return BY_LABEL.get(label);
        }
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
