package core.basesyntax.service;

import core.basesyntax.models.FruitTransfer;
import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler getStrategy(FruitTransfer fruitLot);

}
