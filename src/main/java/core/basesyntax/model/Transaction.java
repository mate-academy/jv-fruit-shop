package core.basesyntax.model;

public enum Transaction {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String transaction;

    Transaction(String transaction) {
        this.transaction = transaction;
    }

    public String getTransaction() {
        return transaction;
    }
}
