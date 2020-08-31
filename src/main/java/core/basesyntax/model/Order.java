package core.basesyntax.model;

import java.util.Objects;

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
                + ", typeOfFruit='" + typeOfFruit + '\''
                + ", quantity=" + quantity
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return quantity == order.quantity
                && Objects.equals(typeOfOperation, order.typeOfOperation)
                && Objects.equals(typeOfFruit, order.typeOfFruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfOperation, typeOfFruit, quantity);
    }
}
