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

        private String letter;

        Operation(String operation) {
            this.letter = operation;
        }

        public String getLetter() {
            return letter;
        }

        public static Operation of(String letter) {
            for (Operation operation : Operation.values()) {
                if (operation.getLetter().equals(letter)) {
                    return operation;
                }
            }
            throw new RuntimeException("Wrong operation letter: " + letter + "!");
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
