package core.basesyntax.model;

public class Transaction {
    private final String action;
    private final String data;

    public Transaction(String action, String data) {
        this.action = action;
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public String getData() {
        return data;
    }
}
