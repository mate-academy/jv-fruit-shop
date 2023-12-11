package core.basesyntax;

public class FruitTransaction {
    private String fruit;
    private int quantity;
    private final Operation operation;

    public FruitTransaction(String fruit, String quantity, int operation) {
        this.fruit = fruit;
        this.quantity = Integer.parseInt(quantity);
        this.operation = Operation.values()[operation];
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "fruitName='" + fruit + '\''
                + ", quantity=" + quantity
                + ", operation='" + operation + '\''
                + '}';
    }
}
