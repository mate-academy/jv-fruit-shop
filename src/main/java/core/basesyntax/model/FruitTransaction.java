package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    private String name;
    private Integer quantity;
    private Operation operation;

    public FruitTransaction(String name, Integer quantity, Operation operation) {
        this.name = name;
        this.quantity = quantity;
        this.operation = operation;
    }
    
    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private static final Map<String, Operation> BY_LABEL = new HashMap<>();

        static {
            for (Operation o : values()) {
                BY_LABEL.put(o.label, o);
            }
        }

        private String label;

        Operation(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }   

        public static Operation getByLabel(String label) {
            return BY_LABEL.get(label);
        }
    }
}
