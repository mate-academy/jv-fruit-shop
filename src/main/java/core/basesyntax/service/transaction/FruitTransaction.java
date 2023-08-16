package core.basesyntax.service.transaction;

import java.util.Map;

public class FruitTransaction {
    private static final Map<String, Operation> OPERATION_MAP = Map.of("b",Operation.BALANCE, "s",
            Operation.SUPPLY, "p", Operation.PURCHASE, "r", Operation.RETURN);
    private Operation operation;
    private String fruit;
    private int quantity;

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

        public static Operation getOperationByString(String string) {
            return OPERATION_MAP.get(string);
        }
    }
}
