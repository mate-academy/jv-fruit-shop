package core.basesyntax;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int amount;

    public FruitTransaction(Operation operation, String fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

        public static Operation fromCode(String code) {
            for (Operation operation : values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Unknown operation ");
        }
    }
}
