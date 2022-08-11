package service;

public class ProductTransaction {
    private Operation operation;
    private String product;
    private int quantity;

    public ProductTransaction(Operation operation, String productName, int quantity) {
        this.operation = operation;
        this.product = productName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getProductName() {
        return product;
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

        public String getOperation() {
            return operation;
        }
    }
}
