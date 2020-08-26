package core.basesyntax.operation;

public class Supply extends OperationGeneral {
    private String typeOfFruit;
    private int quantity;

    public Supply(String typeOfFruit, int quantity) {
        this.typeOfFruit = typeOfFruit;
        this.quantity = quantity;
    }
}
