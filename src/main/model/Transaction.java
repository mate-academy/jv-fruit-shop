package main.model;

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

    public static Transaction getTransactionByCode(String transactionCode) {
        return switch (transactionCode) {
            case "b" -> BALANCE;
            case "s" -> SUPPLY;
            case "p" -> PURCHASE;
            case "r" -> RETURN;
            default -> throw new RuntimeException("Unsupported transaction type: " + transactionCode);
        };
    }
}
