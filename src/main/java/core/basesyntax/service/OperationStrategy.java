package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;

public interface OperationStrategy {
    boolean apply(FruitRecordDto fruitRecordDto);
}
