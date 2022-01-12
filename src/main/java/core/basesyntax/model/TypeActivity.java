package core.basesyntax.model;

public enum TypeActivity {
    BALANCE, SUPPLY, PURCHASE, RETURN;

    public static TypeActivity typeGiven(String typeOperation) {
        switch (typeOperation) {
            case "b":
                return TypeActivity.BALANCE;
            case "p":
                return TypeActivity.PURCHASE;
            case "s":
                return TypeActivity.SUPPLY;
            case "r":
                return TypeActivity.RETURN;
            default:
                throw new RuntimeException("Given type is not provided in the file"
                        + typeOperation);
        }
    }
}

