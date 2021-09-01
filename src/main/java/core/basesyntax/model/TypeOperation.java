package core.basesyntax.model;

import core.basesyntax.exception.ValidationException;

public enum TypeOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String typeInFile;

    TypeOperation(String typeInFile) {
        this.typeInFile = typeInFile;
    }

    public static TypeOperation getType(String operation) {
        switch (operation) {
            case "b":
                return BALANCE;
            case "s":
                return SUPPLY;
            case "r":
                return RETURN;
            case "p":
                return PURCHASE;
            default:
                throw new ValidationException("Incorrect operation");
        }
    }
}
