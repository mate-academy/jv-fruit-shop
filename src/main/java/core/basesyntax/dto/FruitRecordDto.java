package core.basesyntax.dto;

import core.basesyntax.model.Operation;
import java.util.Objects;

public class FruitRecordDto {
    private Operation operationType;
    private String fruitName;
    private Integer quantity;

    public FruitRecordDto(Operation operationType, String fruitName, Integer quantity) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitRecordDto that = (FruitRecordDto) o;
        return operationType == that.operationType
                && Objects.equals(fruitName, that.fruitName)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, fruitName, quantity);
    }

}
