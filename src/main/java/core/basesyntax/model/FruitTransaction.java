package core.basesyntax.model;

public class FruitTransaction extends Fruit {
    private Operation operation;

    private FruitTransaction(String name, int amount, Operation operation) {
        super(name, amount);
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public static FruitTransaction of(String name, int amount, Operation operation) {
        return new FruitTransaction(name, amount, operation);
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