package core.basesyntax.service.operations;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");
    private final String operationTitle;

    Operation(String operationTitle){
        this.operationTitle = operationTitle;
    }

    public String getOperationTitle() {
        return operationTitle;
    }
}
