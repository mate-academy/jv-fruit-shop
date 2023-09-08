package core.basesyntax.model;

public class FruitTransaction {
    public static final String BALANCE_MARKER = "b";
    public static final String SUPPLY_MARKER = "s";
    public static final String RETURN_MARKER = "r";
    public static final String PURCHASE_MARKER = "p";
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction.Operation getOperationLetter(String letter) {
        switch (letter) {
            case BALANCE_MARKER : return Operation.BALANCE;
            case SUPPLY_MARKER : return Operation.SUPPLY;
            case RETURN_MARKER : return Operation.RETURN;
            case PURCHASE_MARKER : return Operation.PURCHASE;
            default: throw new RuntimeException("Invalid operation type");
        }
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
