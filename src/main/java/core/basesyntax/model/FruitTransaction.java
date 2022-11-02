package core.basesyntax.model;

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

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation valueOfLabel(String label) {
            for (Operation operation : values()) {
                if (operation.getOperation().equals(label)) {
                    return operation;
                }
            }
            return null;
        }
    }
}
