package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruitName;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
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

        public static Operation getOperationByCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.code.equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No such operation exists with code: " + code);
        }
    }
}
