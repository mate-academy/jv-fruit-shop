package core.basesyntax.model;

public class FruitTransaction {
    private static final String BALANCE_MARKING = "b";
    private static final String SUPPLY_MARKING = "s";
    private static final String PURCHASE_MARKING = "p";
    private static final String RETURN_MARKING = "r";
    private Operation operation;
    private Fruit fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public FruitTransaction.Operation getOperation(String letter) {
        switch (letter) {
            case BALANCE_MARKING :
                return Operation.BALANCE;
            case SUPPLY_MARKING :
                return Operation.SUPPLY;
            case RETURN_MARKING :
                return Operation.RETURN;
            default:
                return Operation.PURCHASE;
        }
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

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }
}
