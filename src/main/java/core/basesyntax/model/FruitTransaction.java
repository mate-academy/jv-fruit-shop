package core.basesyntax.model;

public class FruitTransaction {
    private final OperationType operation;
    private final String name;
    private final int amount;

    public FruitTransaction(String operation, String fruit, int amount) {
        this.operation = OperationType.valueOf(operation);
        this.name = fruit;
        this.amount = amount;
    }

    public String getFruitName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public OperationType getOperation() {
        return operation;
    }

    public enum OperationType {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        OperationType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
