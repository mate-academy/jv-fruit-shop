package core.basesyntax.model;

import java.util.Arrays;

public class FruitTransaction {
    private Operation operation;
    private Fruit fruit;

    private FruitTransaction(Operation operation, Fruit fruit) {
        this.operation = operation;
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public static FruitTransaction of(Operation operation, Fruit fruit) {
        return new FruitTransaction(operation, fruit);
    }

    public static Operation getOperationByLetter(String firstLetter) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getLetter().equals(firstLetter))
                .findFirst().get();
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

    }
}
