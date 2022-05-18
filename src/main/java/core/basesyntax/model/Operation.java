package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String oneLetter;

    Operation(String oneLetter) {
        this.oneLetter = oneLetter;
    }

    public String getOneLetter() {
        return oneLetter;
    }

    public static Operation of(String oneLetter) {
        switch (oneLetter) {
            case "b" : return Operation.BALANCE;
            case "s" : return Operation.SUPPLY;
            case "p" : return Operation.PURCHASE;
            default : return Operation.RETURN;
        }
    }
}
