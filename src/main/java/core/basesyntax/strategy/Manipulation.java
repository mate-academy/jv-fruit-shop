package core.basesyntax.strategy;

public enum Manipulation {
    RETURN("r"),
    SUPPLY("s"),
    PURCHASE("p"),
    BALANCE("b");

    private final String firstChar;

    Manipulation(String firstChar) {
        this.firstChar = firstChar;
    }

    public String getFirstCharOfManipulation() {
        return firstChar;
    }

    public static Manipulation getManipulation(String firstCharOfManipulation) {
        for (Manipulation manipulation: Manipulation.values()) {
            if (manipulation.getFirstCharOfManipulation().equals(firstCharOfManipulation)) {
                return manipulation;
            }
        }
        return null;
    }
}
