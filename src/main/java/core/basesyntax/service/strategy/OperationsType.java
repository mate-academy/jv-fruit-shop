package core.basesyntax.service.strategy;

public enum OperationsType {
    BALANCE("b", new BalanceOperation()),
    SUPPLY("s", new SupplyOperation()),
    PURCHASE("p", new PurchaseOperation()),
    RETURN("r", new SupplyOperation());

    private String nameOfOperation;
    private Operations operation;

    OperationsType(String nameOfOperation, Operations operation) {
        this.nameOfOperation = nameOfOperation;
        this.operation = operation;
    }

    public String getNameOfOperation() {
        return nameOfOperation;
    }

    public Operations getOperation() {
        return operation;
    }
}
