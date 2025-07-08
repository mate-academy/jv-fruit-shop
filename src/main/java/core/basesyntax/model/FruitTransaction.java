package core.basesyntax.model;

import core.basesyntax.handlers.OperationHandler;
import java.util.Map;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;
    private Map<Operation, OperationHandler> handler;

    public FruitTransaction(String fruit, int quantity, Operation operation) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
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

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation fromCode(String code) {
            for (Operation op : values()) {
                if (op.getCode().equals(code)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown operation code: " + code);
        }
    }
}
