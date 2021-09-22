package core.basesyntax.service;

import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.service.operationstrategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitOperationDto.Type type);
}
