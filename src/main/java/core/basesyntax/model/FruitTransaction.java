package core.basesyntax.model;

public class FruitTransaction {
    private String fruitType;
    private Operation operation;
    private int quantity;

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String type) {
        this.fruitType = type;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

        public static Operation getOperationByFirstLetter(String letter) {
            for (Operation operation: values()) {
                if (operation.letter.equals(letter)) {
                    return operation;
                }
            }
            throw new RuntimeException("There is no such operation with first letter: " + letter);
        }
    }
}
