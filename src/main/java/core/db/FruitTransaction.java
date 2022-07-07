package core.db;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
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

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String letter;

        Operation(String letter) {
            this.letter = letter;
        }

        public String getOperation() {
            return letter;
        }

        public static Operation getOperationByLetter(String letter) {
            return Arrays.stream(Operation.values())
                    .filter(x -> x.getOperation().equals(letter))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException(
                            "Operation with first letter: " + letter + " does not exist"));
        }
    }
}
