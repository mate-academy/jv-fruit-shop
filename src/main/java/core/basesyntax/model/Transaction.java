package core.basesyntax.model;

import static core.basesyntax.model.AvailableOperationsMap.getOperationsMap;

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

        private String abbreviature;

        Operation(String abbreviature) {
            this.abbreviature = abbreviature;
        }

        public String getAbbreviature() {
            return abbreviature;
        }

        public static Operation getOperation(String abbreviature) {
            Map<String, Operation> operationsMap = getOperationsMap();
            return operationsMap.get(abbreviature);
        }
    }
}
