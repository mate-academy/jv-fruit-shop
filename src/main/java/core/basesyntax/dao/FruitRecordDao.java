package core.basesyntax.dao;

import core.basesyntax.model.FruitRecord;
import java.util.List;
import java.util.Map;

public interface FruitRecordDao {

    void saveAll(List<FruitRecord> fruitRecord);

    FruitRecord get(String fruitName);

    List<FruitRecord> getAll();

    Map<String, Integer> getFruitMap();
}
