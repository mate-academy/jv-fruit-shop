package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class Transaction {
    private static final Map<String, Transaction.Operation> operationsMap = new HashMap<>();
    private Operation operation;
    private Fruit fruit;
    private Integer quantity;

    public Transaction(Operation operation, Fruit fruit, Integer quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation getOperation(String abbreviature) {
            return operationsMap.get(abbreviature);
        }

        static {
            for (Transaction.Operation enumOperation : Transaction.Operation.values()) {
                operationsMap.put(enumOperation.getOperation(), enumOperation);
            }
        }
    }
}
