package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int amount;

    public FruitTransaction(Operation operation, String fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public FruitTransaction() {

    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public String setFruit(String fruit) {
        this.fruit = fruit;
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    public Integer setAmount(int amount) {
        this.amount = amount;
        return amount;
    }

    public enum Operation {
        BALANCE("b"),
        PURCHASE("p"),
        RETURN("r"),
        SUPPLY("s");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation mapToOperation(String operationToCheck) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(operationToCheck)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Unknown type of operation incoming : "
                    + operationToCheck);
        }
    }
}
