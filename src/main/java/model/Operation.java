package model;

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

    public static Operation valueOfCode(String code) {
        for (Operation o : values()) {
            if (o.code.equals(code)) {
                return o;
            }
        }
        return null;
    }
}
