package core.basesyntax.operations;

public enum Operations {
    B,
    S,
    P,
    R;

    public static boolean contains(String value) {
        for (Operations operation : Operations.values()) {
            if (operation.toString().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
