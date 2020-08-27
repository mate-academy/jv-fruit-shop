package core.basesyntax.order;

public class Order {
    private String typeOfOperation;
    private String typeOfFruit;
    private int quantity;

    public Order(String typeOfOperation, String typeOfFruit, int quantity) {
        this.typeOfOperation = typeOfOperation;
        this.typeOfFruit = typeOfFruit;
        this.quantity = quantity;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{"
                + "typeOfOperation='"
                + typeOfOperation + '\''
                +
                ", typeOfFruit='" + typeOfFruit + '\''
                +
                ", quantity=" + quantity
                +
                '}';
    }
}
