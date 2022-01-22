package strategy;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operationTypes;

    Operation(String abbreviationActivityType) {
        this.operationTypes = abbreviationActivityType;
    }

    public String getOperationTypes() {
        return operationTypes;
    }

    public static Operation getActivityType(String abbreviationActivityType) {
        for (Operation typeActivity: Operation.values()) {
            if (typeActivity.getOperationTypes().equals(abbreviationActivityType)) {
                return typeActivity;
            }
        }
        return null;
    }
}
