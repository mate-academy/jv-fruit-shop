package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;

public interface ManipulationService {
    void manipulate(String name, int quantity, FruitStorageDao fruitStorageDao);
}
