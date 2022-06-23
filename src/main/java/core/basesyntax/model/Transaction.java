package core.basesyntax.model;

import static core.basesyntax.model.AvailableOperationsMap.operationsMap;

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

        public void setOperation(String operation) {
            this.operation = operation;
        }
    }
}
