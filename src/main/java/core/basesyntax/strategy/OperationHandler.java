package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void operate(Fruit fruit, FruitDao fruitDao);
}
