package core.basesyntax.dto;

public class ProductDto {
    private String operationType;
    private String fruitName;
    private Integer quantity;

    public ProductDto(String operationType, String fruitName, Integer quantity) {
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
