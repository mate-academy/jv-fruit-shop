package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private String letter;

    Operation(String operation) {
        this.letter = operation;
    }

    public String getOperation() {
        return letter;
    }
}
