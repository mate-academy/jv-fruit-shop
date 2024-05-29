package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int amount;

    public FruitTransaction(Operation operation, String fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    public FruitTransaction.Operation getOperation() {
        return operation;
    }

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

        public static Operation convertToOperation(String mark) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(mark)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Unknown Operation");
        }

    }
}
