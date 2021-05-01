package core.basesyntax.model.dto;

public class FruitRecordDto {
    private String operationType;
    private String fruitName;
    private Integer quantity;

    public FruitRecordDto(String operationType, String fruitName, Integer quantity) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
