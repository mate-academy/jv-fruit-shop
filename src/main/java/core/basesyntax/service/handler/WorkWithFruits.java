package core.basesyntax.service.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public interface WorkWithFruits {
    Fruit workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao);
}
