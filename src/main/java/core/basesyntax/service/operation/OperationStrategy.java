package core.basesyntax.service.operation;

import core.basesyntax.model.FruitRecordDto;

public interface OperationStrategy {
    OperationHandler get(FruitRecordDto.Type typeOfOperation);
}
