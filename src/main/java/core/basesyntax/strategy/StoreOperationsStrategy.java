package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandler;

public interface StoreOperationsStrategy {
    DataHandler process(FruitTransaction.Operation operation);
}
