package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitRecordDto.OperationType operationType);
}
