package core.basesyntax.model;

public class FruitTransaction {
    private String fruit;
    private int quantity;

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

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getOperation(String code) {
            for (Operation value : Operation.values()) {
                if (value.getCode().equals(code)) {
                    return value;
                }
            }
            throw new IllegalArgumentException(code + " operation doesn't exist.");
        }

        public String getCode() {
            return code;
        }
    }
}
