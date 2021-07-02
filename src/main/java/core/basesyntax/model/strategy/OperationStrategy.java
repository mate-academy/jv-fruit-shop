package core.basesyntax.model.strategy;

import core.basesyntax.dao.FruitDao;

public interface OperationStrategy {
    void process(FruitDao fruitDao, String name, int quantity);
}
