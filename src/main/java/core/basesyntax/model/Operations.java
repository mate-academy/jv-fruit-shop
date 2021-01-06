package core.basesyntax.model;

public enum Operations {
    R,P,S,B;

    public static Operations getByString(String value) {
        try {
            return Operations.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Illegal operation");
        }
    }
}
