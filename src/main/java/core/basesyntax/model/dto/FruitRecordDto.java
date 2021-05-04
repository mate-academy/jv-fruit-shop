package core.basesyntax.model.dto;

public class FruitRecordDto {
    private String operation;
    private String fruitName;
    private Integer quantity;

    public FruitRecordDto(String operation, String fruitName, Integer quantity) {
        this.operation = operation;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
