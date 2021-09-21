package core.basesyntax.dao;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.FruitRecord;
import java.util.Set;

public interface DAoService {
    void changeAmountOfFruits(FruitRecord fruitRecord);

    void addRemains(FruitRecord fruitRecord);

    Set<Fruit> getSetOfFruitsInStorage();

    Set<Fruit> getWholeStorageCopy();
}
