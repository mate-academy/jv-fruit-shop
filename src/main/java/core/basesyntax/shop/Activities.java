package core.basesyntax.shop;

public enum Activities {
    BALANCE("B"),
    SUPPLY("S"),
    PURCHASE("P"),
    RETURN("R");

    private String type;

    Activities(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static boolean isValid(String activity) {
        for (Activities value : Activities.values()) {
            if (value.getType().equals(activity.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
