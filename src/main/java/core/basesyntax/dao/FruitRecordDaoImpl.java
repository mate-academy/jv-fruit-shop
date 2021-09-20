package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;
import java.util.List;
import java.util.Map;

public class FruitRecordDaoImpl implements FruitRecordDao {

    @Override
    public void saveAll(List<FruitRecord> fruitRecordList) {
        Storage.fruitRecordList.addAll(fruitRecordList);
    }

    @Override
    public FruitRecord get(String fruitName) {
        return Storage.fruitRecordList.stream()
                .filter(f -> f.getFruitName().equals(fruitName))
                .findFirst().orElseThrow();
    }

    @Override
    public List<FruitRecord> getAll() {
        return Storage.fruitRecordList;
    }

    @Override
    public Map<String, Integer> getFruitMap() {
        return Storage.fruitMap;
    }
}
