package core.model;

public enum Operations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operationHandler;

    Operations(String operationHandler) {
        this.operationHandler = operationHandler;
    }

    public String getOperation() {
        return operationHandler;
    }

    public static Operations operationFromString(String operationSignature) {
        for (Operations operations : Operations.values()) {
            if (operations.operationHandler.equalsIgnoreCase(operationSignature)) {
                return operations;
            }
        }
        throw new RuntimeException("Incorrect type of operation: " + operationSignature);
    }
}
