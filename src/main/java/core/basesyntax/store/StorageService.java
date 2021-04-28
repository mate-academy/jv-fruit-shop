package core.basesyntax.store;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;

import java.util.List;

public interface StorageService {
    List<Fruit> saveData(List<FruitRecord> fruitRecordList);

    String getReport(List<Fruit> storage);
}
