package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface ChooseStrategyHandler {
    OperationHandler getHandler(FruitTransaction fruitTransaction);

}
