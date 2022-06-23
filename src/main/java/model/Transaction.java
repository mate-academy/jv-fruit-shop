package model;

public final class Transaction {
    private final Operation operation;
    private final String item;
    private final int quantity;

    public Transaction(Operation operation, String item, int quantity) {
        this.operation = operation;
        this.item = item;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "operation=" + operation
                + ", item='" + item + '\''
                + ", quantity=" + quantity
                + '}';
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
