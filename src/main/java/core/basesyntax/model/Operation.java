package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private String letter;

    Operation(String letter) {
        this.letter = letter;
    }

    public String getOperation() {
        return letter;
    }
}
