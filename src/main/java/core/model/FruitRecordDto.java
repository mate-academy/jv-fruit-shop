package core.model;

public class FruitRecordDto {
    private TypeOperations operationType;
    private String fruitName;
    private Integer quantity;

    public FruitRecordDto(String operationType, String fruitName, String quantity) {
        TypeOperations[] values = TypeOperations.values();
        for (TypeOperations value : values) {
            if (value.get().equals(operationType)) {
                this.operationType = value;
            }
        }
        this.fruitName = fruitName;
        this.quantity = Integer.parseInt(quantity);
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
