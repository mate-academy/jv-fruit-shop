package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private String fruitName;
    private int quantity;

    public Transaction(Operation operation, String fruitName, int quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruit) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getFullName(String abbreviation) {
            for (Operation operation : Operation.values()) {
                if (operation.getOperation().equals(abbreviation)) {
                    return operation;
                }
            }
            return null;
        }

        public String getOperation() {
            return operation;
        }
    }
}
