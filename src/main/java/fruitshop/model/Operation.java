package fruitshop.model;

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

    public static Operation getOperation(String operationCode) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(operationCode)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(operationCode + " operation doesn't exist");
    }
}
