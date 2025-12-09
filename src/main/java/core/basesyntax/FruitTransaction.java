package core.basesyntax;

public class FruitTransaction {

    public enum Operation {
        BALANCE('b'), SUPPLY('S'), RETURN('r'), PURCHASE('p');

        private final char code;

        Operation(char code) {
            this.code = code;
        }

        public char getCode() {
            return code;
        }
    }

    private final Operation operation;
    private final String fruit;
    private final int quantity;

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
}
