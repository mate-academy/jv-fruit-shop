package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.DataHandler;

public interface DataHandlerStrategy {
    DataHandler getHandler(FruitTransaction.Operation activity);
}
