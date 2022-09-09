package core.basesyntax.model;

public class Transaction {
    private final Operation operation;
    private final Fruit fruit;
    private final int quantity;

    public Transaction(Operation operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{" +
                "operation=" + operation +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String firstLetter;

        Operation(String firstLetter) {
            this.firstLetter = firstLetter;
        }

        public String getFirstLetter() {
            return firstLetter;
        }
    }
}
