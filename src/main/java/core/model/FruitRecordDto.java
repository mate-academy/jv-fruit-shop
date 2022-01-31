package core.model;

public class FruitRecordDto {
    private TypeOperations operationType;
    private String fruitName;
    private Integer quantity;

    public FruitRecordDto(TypeOperations operationType, String fruitName, int quantity) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public TypeOperations getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
