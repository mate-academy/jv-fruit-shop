package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String firstLetter;

    Operation(String operation) {
        this.firstLetter = operation;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public static Operation getByFirstLetter(String firstLetter) {
        switch (firstLetter) {
            case "b":
                return Operation.BALANCE;
            case "s":
                return Operation.SUPPLY;
            case "p":
                return Operation.PURCHASE;
            case "r":
                return Operation.RETURN;
            default:
                throw new RuntimeException("Operation is no found " + firstLetter);
        }
    }
}
