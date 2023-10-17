package fruitshop.model.dto;

import fruitshop.service.shopoperation.OperationType;
import java.math.BigDecimal;

public class FruitOperationDto {
    private final OperationType operationType;
    private final String fruitName;
    private final BigDecimal quantity;

    public FruitOperationDto(OperationType operationType, String fruitName, BigDecimal quantity) {
        this.operationType = operationType;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getFruitName() {
        return fruitName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
