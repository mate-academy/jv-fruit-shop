package core.basesyntax.strategy;

public enum Manipulations {
    RETURN("r"),
    SUPPLY("s"),
    PURCHASE("p"),
    BALANCE("b");


    private final String firstCharOfManipulation;

    Manipulations(String firstCharOfManipulation) {
        this.firstCharOfManipulation = firstCharOfManipulation;
    }

    public String getFirstCharOfManipulation() {
        return firstCharOfManipulation;
    }

    public static Manipulations getManipulation(String firstCharOfManipulation) {
        for (Manipulations manipulations: Manipulations.values()) {
            if (manipulations.getFirstCharOfManipulation().equals(firstCharOfManipulation)) {
                return manipulations;
            }
        }
        return null;
    }
}
