package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    final private String operationSignature;

    Operation(String text) {
        this.operationSignature = text;
    }

    public String getOperation() {
        return operationSignature;
    }

    public static Operation fromString(String text) {
        for (Operation operation : Operation.values()) {
            if (operation.operationSignature.equalsIgnoreCase(text)) {
                return operation;
            }
        }
        throw new RuntimeException("Operation is incorrect " + text);
    }
}
