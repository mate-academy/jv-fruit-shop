package core.basesyntax.model;

import java.util.Arrays;

public class TransactionDto {
    private Operation operation;
    private String fruit;
    private int quantity;

    public TransactionDto(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
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
            return Arrays.stream(Operation.values())
                    .filter(e -> e.getCode().equals(operationCode))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Code is invalid: " + operationCode));
        }
    }
}
