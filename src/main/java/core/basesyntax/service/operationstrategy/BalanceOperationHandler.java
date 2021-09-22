package core.basesyntax.service.operationstrategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.ValidationException;
import core.basesyntax.model.FruitOperationDto;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void handler(FruitOperationDto dto) throws ValidationException {
        Storage.fruitStorage.put(dto.getFruitName(), dto.getQuantity());
    }
}
