package core.basesyntax.strategy;

public enum Manipulation {
    RETURN("r"),
    SUPPLY("s"),
    PURCHASE("p"),
    BALANCE("b");

    private final String firstCharOfManipulation;

    Manipulation(String firstCharOfManipulation) {
        this.firstCharOfManipulation = firstCharOfManipulation;
    }

    public String getFirstCharOfManipulation() {
        return firstCharOfManipulation;
    }

    public static Manipulation getManipulation(String firstCharOfManipulation) {
        for (Manipulation manipulations: Manipulation.values()) {
            if (manipulations.getFirstCharOfManipulation().equals(firstCharOfManipulation)) {
                return manipulations;
            }
        }
        return null;
    }
}
