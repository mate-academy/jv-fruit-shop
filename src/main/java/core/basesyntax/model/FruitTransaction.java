package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final Fruit fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, Fruit fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String letter;

        Operation(String letter) {
            this.letter = letter;
        }

        public String getLetter() {
            return letter;
        }

        public static Operation findOperationByLetter(String letter) {
            for (Operation operation : Operation.values()) {
                if (operation.getLetter().equals(letter)) {
                    return operation;
                }
            }
            throw new RuntimeException("Wrong Operation Index");
        }
    }
}
