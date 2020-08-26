package core.basesyntax;

public class Transaction {
    private String type;
    private String fruit;
    private String date;
    private String quantity;

    public void setType(String type) {
        this.type = type;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getQuantity() {
        return quantity;
    }
}
