package model;

import jdk.jfr.Description;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Description("Using this method - should do the null check"
            + "returns null if such operation doesn't exist")
    public static Operation getOperation(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(code)) {
                return Operation.valueOf(operation.name());
            }
        }
        return null;
    }
}
