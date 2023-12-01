package model;

public enum Transaction {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Transaction(String code) {
        this.code = code;
    }

    public static Transaction getTransactionFromCode(String transactionValue) {
        return switch (transactionValue) {
            case "b" -> BALANCE;
            case "s" -> SUPPLY;
            case "p" -> PURCHASE;
            case "r" -> RETURN;
            default -> throw new RuntimeException("You have entered a non-existent transaction."
                    + transactionValue
                    + "Available values: BALANCE, SUPPLY, PURCHASE, RETURN");
        };
    }
}
