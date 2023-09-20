package core.basesyntax.model;

import java.util.Arrays;

public enum Transaction {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Transaction(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Transaction getTransactionByCode(String code) {
        return Arrays.stream(Transaction.values())
                .filter(t -> t.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can`t find transaction by code"));
    }
}
