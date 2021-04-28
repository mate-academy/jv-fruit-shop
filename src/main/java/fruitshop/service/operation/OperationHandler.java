package fruitshop.service.operation;

import fruitshop.model.dto.FruitDto;

public interface OperationHandler {
    FruitDto apply(FruitDto fruitDto);
}
