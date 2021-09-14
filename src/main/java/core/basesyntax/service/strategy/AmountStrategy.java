package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.amount.AmountHandler;

public interface AmountStrategy {
    AmountHandler get(FruitRecord.Type operationType);
}
