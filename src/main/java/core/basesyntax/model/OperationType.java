package core.basesyntax.model;

public enum OperationType {
    B,
    S,
    P,
    R;

    public static boolean isPresent(String value) {
        for (OperationType operation : OperationType.values()) {
            if (operation.toString().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
