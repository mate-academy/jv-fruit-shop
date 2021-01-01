package core.basesyntax.fruitoperation;

public enum Operations {
    B, S, P, R;

    public static boolean contains(String value) {
        try {
            Operations.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
