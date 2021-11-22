package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.strategy.FruitWorkStrategy;

public interface StrategyService {
    void workWithStrategy(String[] fileData, FruitWorkStrategy fruitWork, FruitDao fruitDao);
}
