package core.basesyntax.model;

public class Transaction {
    private String operation;
    private Fruit fruit;
    private Integer quantity;

    public Transaction() {
    }

    public Transaction(String[] data) {
        this.operation = data[0];
        this.fruit = Fruit.of(data[1]);
        this.quantity = Integer.parseInt(data[2]);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "operation='" + operation + '\'' +
                ", fruit=" + fruit +
                ", quantity=" + quantity +
                '}';
    }
}
