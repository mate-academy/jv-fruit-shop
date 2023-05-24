package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    private FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
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

    public static class FruitTransactionBuilder {
        private Operation operation;
        private String fruit;
        private int quantity;

        public FruitTransactionBuilder setOperation(Operation operation) {
            this.operation = operation;
            return this;
        }

        public FruitTransactionBuilder setFruit(String fruit) {
            this.fruit = fruit;
            return this;
        }

        public FruitTransactionBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public FruitTransaction build() {
            return new FruitTransaction(operation, fruit, quantity);
        }
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

        public static Operation getOperationByLetter(String letter) {
            for (Operation operation : Operation.values()) {
                if (operation.letter.equals(letter)) {
                    return operation;
                }
            }
            throw new RuntimeException("Wrong operation letter inserted: " + letter);
        }

        public String getLetter() {
            return letter;
        }
    }
}
