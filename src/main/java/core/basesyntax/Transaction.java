package core.basesyntax;

public class Transaction {
    private String operation;
    private String fruitItem;
    private String quantity;
    private String date;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setFruitItem(String fruitItem) {
        this.fruitItem = fruitItem;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitItem() {
        return fruitItem;
    }

    public String getQuantity() {
        return quantity;
    }

}
