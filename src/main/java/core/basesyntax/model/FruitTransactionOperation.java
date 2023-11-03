package core.basesyntax.model;

public enum FruitTransactionOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;
    FruitTransactionOperation(String code) {
        this.code = code;
    }

    public static FruitTransactionOperation getOperation(String operationLetter) {
        for (FruitTransactionOperation operation : FruitTransactionOperation.values()) {
            if (operation.code.equals(operationLetter)) {
                return operation;
            }
        }
        throw new RuntimeException("no such operation: " + operationLetter);
    }
}
