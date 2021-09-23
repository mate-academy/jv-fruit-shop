package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitRecordDto.Type operation);
}
