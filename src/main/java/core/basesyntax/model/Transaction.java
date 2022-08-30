package core.basesyntax.model;

public class Transaction {
    private String operation;
    private Fruit fruit;
    private Integer quantity;

    public Transaction(String operation, Fruit fruit, Integer quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "operation='"
                + operation + '\'' + ", fruit="
                + fruit + ", quantity=" + quantity
                + '}';
    }
}
