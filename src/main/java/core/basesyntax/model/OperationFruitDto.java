package core.basesyntax.model;

public class OperationFruitDto {
    private String operation;
    private String name;
    private int quantity;

    public OperationFruitDto(String operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
