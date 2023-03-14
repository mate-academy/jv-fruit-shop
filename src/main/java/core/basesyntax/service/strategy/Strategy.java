package core.basesyntax.service.strategy;

import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.operation.FruitService;

public interface Strategy {

    FruitService choosePattern(FruitTransaction fruitTransaction);

}
