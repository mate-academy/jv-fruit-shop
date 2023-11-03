package core.basesyntax.transaction;

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
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation getOperation(String code) {
            return switch (code) {
                case "b" -> BALANCE;
                case "s" -> SUPPLY;
                case "p" -> PURCHASE;
                case "r" -> RETURN;
                default -> throw new RuntimeException("The provided operation code "
                        + "is invalid: " + code);
            };
        }

        public String getCode() {
            return code;
        }
    }
}
