package core.basesyntax.fruitoperation;

public enum Operations {
    B, S, P, R;

    public static boolean contains(String value) {
        for (Operations operation : Operations.values()) {
            if (operation.toString().equals(value.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
