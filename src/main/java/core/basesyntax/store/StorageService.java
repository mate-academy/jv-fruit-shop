package core.basesyntax.store;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;

import java.util.List;

public interface StorageService {
    List<Fruit> getReport(List<FruitRecord> fruitRecordList);

    void reportMaker(String path, List<Fruit> storage);

    void createNewFruit(String name, long quantity);

    Fruit makeFruit(String name, long quantity);
}
