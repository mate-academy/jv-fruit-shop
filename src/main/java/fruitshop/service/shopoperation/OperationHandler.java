package fruitshop.service.shopoperation;

import fruitshop.exception.FruitQuantityException;
import fruitshop.model.dto.FruitOperationDto;
import java.math.BigDecimal;

public interface OperationHandler {
    FruitOperationDto apply(FruitOperationDto fruitOperationDto);

    default BigDecimal getVariationValue(FruitOperationDto fruitOperationDto) {
        BigDecimal variationValue = fruitOperationDto.getQuantity();
        if (variationValue.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new FruitQuantityException("Fruits quantity cannot be negative");
        }
        return variationValue;
    }
}
