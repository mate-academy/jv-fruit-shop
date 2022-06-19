package core.basesyntax.model;

public class Transaction {

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

        public static Operation getOperationFromString(String operation) {
            if (operation.equals("b")) {
                return BALANCE;
            }
            if (operation.equals("s")) {
                return SUPPLY;
            }
            if (operation.equals("p")) {
                return PURCHASE;
            }
            if (operation.equals("r")) {
                return RETURN;
            }
            return null;
        }
    }


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

    public void setOperation(Operation operation) {
        this.operation = operation;
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
}
