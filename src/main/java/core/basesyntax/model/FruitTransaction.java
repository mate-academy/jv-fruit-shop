package core.basesyntax.model;

import java.util.NoSuchElementException;

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

        Operation(String operation) {
            this.letter = operation;
        }

        public String getOperation() {
            return letter;
        }

        public static Operation findOperationByLetter(String letter) {
            for (Operation op : Operation.values()) {
                if (op.getOperation().equals(letter)) {
                    return op;
                }
            }
            throw new NoSuchElementException("Can't find such Operation" + letter);
        }
    }
}
