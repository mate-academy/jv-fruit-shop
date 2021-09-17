package core.basesyntax.service.amount;

import core.basesyntax.model.FruitRecord;

public interface AmountHandler {
    boolean apply(FruitRecord newFruitRecord);
}
