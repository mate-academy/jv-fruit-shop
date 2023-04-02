package core.basesyntax;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operationMark;

    Operation(String operationMark) {
        this.operationMark = operationMark;
    }

    public String getOperationMark() {
        return this.operationMark;
    }
}
