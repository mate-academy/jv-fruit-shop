package services.transaction.model;

import java.util.HashMap;
import java.util.Map;

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

        private static final Map<String, Operation> SHORT_FORM = new HashMap<>();

        static {
            for (Operation e : values()) {
                SHORT_FORM.put(e.operation, e);
            }
        }

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getOperation(String value) {
            return SHORT_FORM.get(value);
        }

    }
}
