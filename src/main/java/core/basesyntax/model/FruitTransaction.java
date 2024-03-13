package core.basesyntax.model;

public class FruitTransaction {
    private TypeOfFruit typeOfFruit;
    private int quantity;
    private Operation operation;

    public TypeOfFruit getTypeOfFruit() {
        return typeOfFruit;
    }

    public void setTypeOfFruit(TypeOfFruit typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
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

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "FruitInfo{"
                + "fruitType=" + typeOfFruit
                + ", quantity=" + quantity
                + ", activities='"
                + operation + '\'' + '}';
    }
}
