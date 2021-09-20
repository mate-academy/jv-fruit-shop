package core.basesyntax.dao;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface FruitsDao {
    boolean addRecord(FruitRecord fruitRecord);

    List<FruitRecord> getRecords();
}
