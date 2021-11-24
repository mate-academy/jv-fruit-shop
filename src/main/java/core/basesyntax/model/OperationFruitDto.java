package core.basesyntax.model;

public class OperationFruitDto {
    private String operation;
    private String nameFruit;
    private int quantity;

    public OperationFruitDto(String operation, String nameFruit, int quantity) {
        this.operation = operation;
        this.nameFruit = nameFruit;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
