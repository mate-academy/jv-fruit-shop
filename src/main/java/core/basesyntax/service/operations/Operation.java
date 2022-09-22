package core.basesyntax.service.operations;

public enum Operation {
    B("BALANCE"),
    P("PURCHASE"),
    R("RETURN"),
    S("SUPPLY");
    private final String operationTitle;

    Operation(String operationTitle){
        this.operationTitle = operationTitle;
    }
    public String getTitle(){
        return operationTitle;
    }

    public String getOperationTitle() {
        return operationTitle;
    }
}
