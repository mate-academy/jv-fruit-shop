package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction() {

    }

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String firstLetterOfOperation;

        Operation(String firstLetterOfOperation) {
            this.firstLetterOfOperation = firstLetterOfOperation;
        }

        public String getFirstLetterOfOperation() {
            return firstLetterOfOperation;
        }

        public static Operation fromCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.firstLetterOfOperation.equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Invalid operation code: " + code);
        }

        public static Operation getOperation(String firstLetterOfOperation) {
            for (Operation operation : Operation.values()) {
                if (operation.firstLetterOfOperation.equals(firstLetterOfOperation)) {
                    return operation;
                }
            }
            return null;
        }
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
