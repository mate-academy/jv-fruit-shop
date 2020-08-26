package core.basesyntax.operation;

public class Supply extends OperationGeneral {
    private String typeOfOperation;
    private String typeOfFruit;
    private int quantity;

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public Supply(String typeOfOperation, String typeOfFruit, int quantity) {
        this.typeOfOperation = typeOfOperation;
        this.typeOfFruit = typeOfFruit;
        this.quantity = quantity;
    }

    @Override
    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    @Override
    public void setTypeOfFruit(String typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "typeOfFruit='" + typeOfFruit + '\'' +
                ", quantity=" + quantity +
                '}';
    }


}
