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

    public void setAction(String action) {
        this.action = action;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
