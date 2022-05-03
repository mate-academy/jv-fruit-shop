package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public FruitTransaction(Operation operation, Fruit fruit, int quantity) {
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

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public static Operation getOperation(String option) {
            switch (option) {
                case "b":
                    return FruitTransaction.Operation.BALANCE;
                case "p":
                    return FruitTransaction.Operation.PURCHASE;
                case "s":
                    return FruitTransaction.Operation.SUPPLY;
                case "r":
                    return FruitTransaction.Operation.RETURN;
                default:
                    throw new RuntimeException("Unknown operation " + option);
            }
        }
    }
}
