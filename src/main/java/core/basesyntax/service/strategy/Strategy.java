package core.basesyntax.service.strategy;

import core.basesyntax.service.model.FruitTransaction;

public interface Strategy {

    FruitHandler choosePattern(FruitTransaction fruitTransaction);

}
