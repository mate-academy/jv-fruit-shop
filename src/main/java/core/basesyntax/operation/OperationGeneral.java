package core.basesyntax.operation;

public abstract class OperationGeneral {
    private String typeOfFruit;
    private int quantity;

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public void setTypeOfFruit(String typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OperationGeneral{" +
                "typeOfFruit='" + typeOfFruit + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
