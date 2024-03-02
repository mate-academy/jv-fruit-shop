package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitName() {
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
        private static final Map<String, Operation> operationMap;
        private String code;

        static {
            operationMap = new HashMap<>();
            operationMap.put("b", FruitTransaction.Operation.BALANCE);
            operationMap.put("s", FruitTransaction.Operation.SUPPLY);
            operationMap.put("p", FruitTransaction.Operation.PURCHASE);
            operationMap.put("r", FruitTransaction.Operation.RETURN);
        }

        Operation(String code) {
            this.code = code;
        }

        public static FruitTransaction.Operation getOperation(String operationCode) {
            return operationMap.get(operationCode);
        }
    }
}
