package core.basesyntax.model;

public class FruitTransaction {
    private String fruitName;
    private int quantity;
    private Operation operation;

    public FruitTransaction(String fruitName, int quantity, Operation operation) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation fromCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.code.equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No enum constant with code: " + code);
        }
    }
}
