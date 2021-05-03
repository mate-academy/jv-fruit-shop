package core.basesyntax.model;

public enum Operation {

    BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

    private String shortName;

    Operation(String b) {
        this.shortName = b; // тут приймає значення "b" "s" "p" "r"
    }

    public String getShortNameOperation() {
        return shortName;
    }

    public static Operation getOperationByShortName(String operationType) {
        for (Operation operation : Operation.values()) {
            if (operation.getShortNameOperation().equals(operationType)) {
                return operation;
            }
        }
        throw new RuntimeException("This operation is missing - " + operationType);
    }
}
