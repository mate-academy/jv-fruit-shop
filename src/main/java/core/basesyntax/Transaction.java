package core.basesyntax;

public class Transaction {
    private String action;
    private String fruit;
    private String quantity;
    private String date;

    public Transaction(String action, String fruit, String quantity, String date) {
        this.action = action;
        this.fruit = fruit;
        this.quantity = quantity;
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public String getFruit() {
        return fruit;
    }

    public String getQuantity() {
        return quantity;
    }
}
