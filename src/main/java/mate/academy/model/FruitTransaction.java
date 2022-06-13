package mate.academy.model;

public class FruitTransaction {
    private final String operation;
    private final String fruite;
    private final int quantity;

    public FruitTransaction(String operation, String fruite, int quantity) {
        this.operation = operation;
        this.fruite = fruite;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruite() {
        return fruite;
    }

    public int getQuantity() {
        return quantity;
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

        public String getOperations() {
            return operation;
        }

    }

}
