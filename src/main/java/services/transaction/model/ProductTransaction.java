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

        private static final Map<String, Operation> OPERATION_MAP = new HashMap<>();
        private final String operation;

        static {
            for (Operation e : values()) {
                OPERATION_MAP.put(e.operation, e);
            }
        }

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getOperation(String value) {
            return OPERATION_MAP.get(value);
        }
    }
}
