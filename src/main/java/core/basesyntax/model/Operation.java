package core.basesyntax.model;

public enum Operation {

    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String letter;

    Operation(String letter) {
        this.letter = letter;
    }

    public String getOperation() {
        return letter;
    }

}
