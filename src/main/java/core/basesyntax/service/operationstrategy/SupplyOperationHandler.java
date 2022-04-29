package core.basesyntax.service.operationstrategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.ValidationException;
import core.basesyntax.model.FruitOperationDto;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handler(FruitOperationDto dto) throws ValidationException {
        Integer intermediateResult = Storage.fruitStorage.get(dto.getFruitName());
        intermediateResult += dto.getQuantity();
        Storage.fruitStorage.put(dto.getFruitName(), intermediateResult);
    }
}
