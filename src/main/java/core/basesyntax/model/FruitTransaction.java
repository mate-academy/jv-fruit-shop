package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private Integer amount;

    public FruitTransaction() {
    }

    public FruitTransaction(Operation operation, String fruit, Integer amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
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

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public enum Operation {
        BALANCE("b"),
        SUPLLY("r"),
        PURCHES("p"),
        RETURE("r");

        private final String operationString;

        Operation(String operationString) {
            this.operationString = operationString;
        }

        public String getOperationString() {
            return operationString;
        }

        public static Operation get(String operationString) {
            if (operationString.equals("b")) {
                return BALANCE;
            }
            if (operationString.equals("s")) {
                return SUPLLY;
            }
            if (operationString.equals("p")) {
                return PURCHES;
            }
            if (operationString.equals("r")) {
                return RETURE;
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruit='" + fruit + '\''
                + ", amount=" + amount
                + '}';
    }
}
