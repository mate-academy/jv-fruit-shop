package core.basesyntax.dto;

public class FruitTransactionDto {
    private final String operationType;
    private final String nameFruit;
    private final int quantity;

    public FruitTransactionDto(String operationType, String nameFruit, int quantity) {
        this.operationType = operationType;
        this.nameFruit = nameFruit;
        this.quantity = quantity;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
