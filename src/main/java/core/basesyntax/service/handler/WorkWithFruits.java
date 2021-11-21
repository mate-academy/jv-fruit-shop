package core.basesyntax.service.handler;

import core.basesyntax.dao.FruitDao;

public interface WorkWithFruits {
    void workWithFruitInStorage(int fruitNumber, String fruitName, FruitDao fruitDao);
}
