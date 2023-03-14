package core.basesyntax.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StorageTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public StorageTransaction(Operation operation, String fruit, int quantity) {
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getOperation(String code) {
            return Arrays.stream(Operation.values())
                    .filter(t -> t.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("There is no such operation"));
        }

        public String getCode() {
            return code;
        }
    }
}
