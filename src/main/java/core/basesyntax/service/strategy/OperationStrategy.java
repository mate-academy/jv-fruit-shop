package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.amount.AmountHandler;

public interface OperationStrategy {
    AmountHandler get(FruitRecord.Type operationType);
}
