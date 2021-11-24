package service;

public enum Operation {
    PURCHASE("p"),
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r");

    private String value;

    Operation(String value) {
        this.value = value;
    }

    public static Operation getKey(String value) {
        for (Operation operation : Operation.values()) {
            if (operation.value.equals(value)) {
                return operation;
            }
        }
        throw new RuntimeException("Operation not found");
    }

    public static boolean contains(String value) {
        for (Operation operation : Operation.values()) {
            if (operation.value.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
