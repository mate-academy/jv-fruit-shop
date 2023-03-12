package model;

import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;
    private final Map<String, Operation> operationStringMap = new HashMap<>();

    public FruitTransaction() {
        createOperationStringMap();
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

    public Operation getOperationByLetter(String letter) {
        return operationStringMap.get(letter);
    }

    private void createOperationStringMap() {
        for (Operation operation : Operation.values()) {
            operationStringMap.put(operation.operation, operation);
        }
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
    }
}
