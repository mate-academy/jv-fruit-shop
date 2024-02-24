package core.basesyntax.model;

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

        private static Map<String, Operation> operationMap;
        private String code;

        static {
            operationMap = Map.of("b", Operation.BALANCE,
                    "s", Operation.SUPPLY,
                    "p", Operation.PURCHASE,
                    "r", Operation.RETURN);
        }

        Operation(String code) {
            this.code = code;
        }

        public static Operation getOperation(String operation) {
            return operationMap.get(operation);
        }
    }
}

