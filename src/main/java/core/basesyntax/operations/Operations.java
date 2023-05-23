package core.basesyntax.operations;

public enum Operations {
    B,
    S,
    P,
    R;

    public static boolean contains(String values) {
        for (Operations operation : Operations.values()) {
            if (operation.toString().equalsIgnoreCase(values)) {
                return true;
            }
        }
        return false;
    }
}
