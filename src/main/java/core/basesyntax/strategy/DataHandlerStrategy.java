package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.DataHandler;

public interface DataHandlerStrategy {
    DataHandler getHandler(FruitTransaction.Operation activity);
}
