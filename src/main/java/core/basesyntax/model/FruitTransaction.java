package core.basesyntax.model;

public class FruitTransaction {
    public enum Operation {
        BALANCE('b'), SUPPLY('s'), RETURN('r'), PURCHASE('p');

        private final char code;

        Operation(char code) {
            this.code = code;
        }

        public char getCode() {
            return code;
        }

        public static Operation getByCode(char code) {
            for (Operation operation : values()) {
                if (operation.code == code) {
                    return operation;
                }
            }
            throw new RuntimeException("Unknown operation code: " + code);
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
