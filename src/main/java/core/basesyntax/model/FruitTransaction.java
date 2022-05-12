package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final Fruit fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
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

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation findOperationByLetter(String letter) {
            for (Operation op : Operation.values()) {
                if (op.getOperation().equals(letter)) {
                    return op;
                }
            }
            throw new RuntimeException("Wrong Operation Index");
        }
    }
}
