package core.basesyntax.model;

public enum TypeOfOperation {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String typeOfOperation;

    TypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public static TypeOfOperation getOperation(String typeOfOperation) {
        for (TypeOfOperation type: TypeOfOperation.values()) {
            if (type.getTypeOfOperation().equals(typeOfOperation)) {
                return type;
            }
        }
        return null;
    }
}
