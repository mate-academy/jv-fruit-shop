package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void processData(FruitDao fruitDao, Fruit fruit, int quantity);
}
