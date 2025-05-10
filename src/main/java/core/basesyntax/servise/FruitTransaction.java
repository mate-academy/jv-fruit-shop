package core.basesyntax.servise;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String code, String fruit, int quantity) {
        this.operation = Operation.valueOfCode(code);
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

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation valueOfCode(String code) {
            for (Operation element : values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
            throw new RuntimeException("Invalid code value of operation: " + code);
        }
    }
}
