package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public interface OperationHandler {
    Integer calculateNewAmount(FruitDao fruitDao, Fruit fruit, Integer amount);
}
