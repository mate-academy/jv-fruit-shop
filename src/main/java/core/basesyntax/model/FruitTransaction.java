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

    @Override
    public String toString() {
        return "operation=" + operation
               + ", fruit='" + fruit + '\''
               + ", quantity=" + quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public FruitTransaction.Operation getOperationByCode(String code) {
        return switch (code) {
            case "b" -> Operation.BALANCE;
            case "s" -> Operation.SUPPLY;
            case "p" -> Operation.PURCHASE;
            case "r" -> Operation.RETURN;
            default -> throw new RuntimeException("Unexpected value: " + code);
        };
    }
}
