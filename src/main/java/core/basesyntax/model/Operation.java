package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),

    SUPPLY("s"),

    PURCHASE("p"),

    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation getOperationFromCode(String operationValue) {
        Operation[] operations = Operation.values();
        for (Operation operation : operations) {
            if (operation.code.equals(operationValue)) {
                return operation;
            }
        }
        throw new RuntimeException("You have entered a non-existent transaction."
                + operationValue
                + "Available values: BALANCE, SUPPLY, PURCHASE, RETURN");
    }
}
