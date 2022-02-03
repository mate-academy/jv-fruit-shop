package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.DataHandler;

public interface StoreOperationsStrategy {
    DataHandler process(Operation operation);
}
