package core.basesyntax.service;

import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    // getters, setters, ...

    public FruitTransaction(Operation operation) {
        this.operation = operation;
    }

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
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

        private static final Map<String, Operation> BY_CODE = new HashMap<>();
        private final String code;

        static {
            for (Operation o : values()) {
                BY_CODE.put(o.code, o);
            }
        }

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation getByCode(String code) {
            return BY_CODE.get(code);
        }
    }
}
