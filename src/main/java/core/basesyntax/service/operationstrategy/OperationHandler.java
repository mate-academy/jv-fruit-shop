package core.basesyntax.service.operationstrategy;

import core.basesyntax.exception.ValidationException;
import core.basesyntax.model.FruitOperationDto;

public interface OperationHandler {
    void handler(FruitOperationDto dto) throws ValidationException;
}
