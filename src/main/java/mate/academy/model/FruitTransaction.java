package mate.academy.model;//*

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String operationCode, String fruit, int quantity) {
        this.operation = getOperationByCode(operationCode);
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

    @Override
    public String toString() {
        return "FruitTransaction{" + "operation=" + operation + ", fruit='" + fruit + '\'' + ", quantity=" + quantity + '}';
    }

    private Operation getOperationByCode(String operationCode) {
        for (Operation value : Operation.values()) {
            if (value.getCode().equals(operationCode)) {
                return value;
            }
        }
        throw new RuntimeException("Can't find operation code: " + operationCode);
    }

    public enum Operation {
        BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
