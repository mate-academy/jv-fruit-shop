package core.basesyntax.model;

public class FruitTransaction extends Fruit {
    private Operation operation;

    public FruitTransaction(String operation, String fruit, int quantity) {
        super(fruit,quantity);
        switch (operation) {
            case "b" -> this.operation = Operation.BALANCE;
            case "s" -> this.operation = Operation.SUPPLY;
            case "p" -> this.operation = Operation.PURCHASE;
            case "r" -> this.operation = Operation.RETURN;
            default -> throw new RuntimeException("Can't find operation");
        }
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    // getters, setters, ...

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
