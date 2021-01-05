package core.basesyntax.model;

public enum Operations {
    R,P,S,B;

    public static boolean contains(String value) {
        try {
            Operations.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
