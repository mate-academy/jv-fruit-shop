package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operation, String fruit, int quantity) {
        this.operation = Operation.of(operation);
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
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

        public static Operation of(String letter) {
            switch (letter) {
                case "b" :
                    return Operation.BALANCE;
                case "s" :
                    return Operation.SUPPLY;
                case "p" :
                    return Operation.PURCHASE;
                default :
                    return Operation.RETURN;
            }
        }
    }

    @Override
    public String toString() {
        return System.lineSeparator()
                + "FruitTransaction{operation=" + operation
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity + '}';
    }
}
