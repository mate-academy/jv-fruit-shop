package model;

import java.util.Objects;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation getByType(String type) {
        for (Operation item : Operation.values()) {
            if (Objects.equals(item.getCode(), type)) {
                return item;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }
}
