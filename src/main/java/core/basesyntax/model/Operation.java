package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getByCode(String type) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(type.strip())) {
                return operation;
            }
        }
        throw new RuntimeException("Code doesn't exist");
    }
}

