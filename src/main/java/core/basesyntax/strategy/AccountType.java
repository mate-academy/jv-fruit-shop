package core.basesyntax.strategy;

public enum AccountType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    AccountType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static AccountType fromCode(String code) {
        for (AccountType op : AccountType.values()) {
            if (op.code.equals(code)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operation: " + code);
    }
}
