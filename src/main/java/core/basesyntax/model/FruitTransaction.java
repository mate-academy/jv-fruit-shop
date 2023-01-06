package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

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

        private String letter;

        Operation(String letter) {
            this.letter = letter;
        }

        public static Operation getOperationByLetter(String letter) {
            for (Operation operation : Operation.values()) {
                if (operation.letter.equals(letter)) {
                    return operation;
                }
            }
            throw new RuntimeException("Can't find an operation by letter " + letter);
        }
    }
}
