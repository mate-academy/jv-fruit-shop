package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private final Operation operation;
    private final String productName;
    private final int quantity;

    public FruitTransaction(Operation operation, String productName, int quantity) {
        this.operation = operation;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public Operation getOperation() {
        return operation;
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

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String operationCode) {
            return Arrays.stream(values())
                    .filter(operation -> operation.getCode().equals(operationCode))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Invalid operation code '"
                            + operationCode + '\''));
        }
    }
}
