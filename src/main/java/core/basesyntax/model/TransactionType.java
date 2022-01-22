package core.basesyntax.model;

public enum TransactionType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    TransactionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static TransactionType of(String code) {
        for (TransactionType type : TransactionType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }
}
