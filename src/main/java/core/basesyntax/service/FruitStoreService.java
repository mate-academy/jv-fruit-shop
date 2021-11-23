package core.basesyntax.service;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ManipulationService;
import core.basesyntax.strategy.Manipulations;
import java.util.List;
import java.util.Map;

public interface FruitStoreService {
    List<Fruit> changeBalance(List<String> data, Map<Manipulations,
            ManipulationService> manipulationServiceMap,FruitStorageDao fruitStorageDao);
}
