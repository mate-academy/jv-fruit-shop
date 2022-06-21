package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;
public class Transaction {
    private Operation abbreviature;
    private Fruit fruit;
    private Integer quantity;

    public Transaction(Operation operation, Fruit fruit, Integer quantity) {
        this.abbreviature = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getAbbreviature() {
        return abbreviature;
    }

    public void setAbbreviature(Operation abbreviature) {
        this.abbreviature = abbreviature;
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

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public static Operation getOperation(String abbreviature) {
            Map<String, Operation> operationMap = new HashMap<>();
            for (Operation enumOperation : Operation.values()) {
                operationMap.put(enumOperation.getOperation(), enumOperation);
            }
            return operationMap.get(abbreviature);
        }
    }
}
