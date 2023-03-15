package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;

public interface ChooseStrategyHandler {
    OperationHandler get(FruitTransaction fruitTransaction);

}
