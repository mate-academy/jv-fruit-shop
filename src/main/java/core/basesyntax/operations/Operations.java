package core.basesyntax.operations;

public enum Operations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    Operations(String operation) {
        this.operation = operation;
    }

    public String getOperationValue() {
        return operation;
    }

    public static boolean contains(String operation) {
        for (Operations value : Operations.values()) {
            if (operation.equals(value.getOperationValue())) {
                return true;
            }
        }
        return false;
    }

    public static Operations getEnumByString(String symbol) {
        for (Operations operation : Operations.values()) {
            if (operation.getOperationValue().equals(symbol)) {
                return operation;
            }
        }
        throw new RuntimeException("Such operation doesn't exist");
    }
}
