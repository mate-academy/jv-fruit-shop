package core.basesyntax.model;

public class Transaction {
    private Operation operation;
    private Fruit fruit;
    private Integer quantity;

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

        public static Operation getFromString(String letter) {
            for (Operation operation : Operation.values()) {
                if (operation.getOperation().equals(letter)) {
                    return operation;
                }
            }
            throw new RuntimeException("Unknown symbol of operation");
        }

    }

    public Transaction(Operation operation, Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.operation = operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FruitShop{"
                + "fruit=" + fruit
                + ", operation=" + operation
                + ", quantity=" + quantity + '}';
    }
}
