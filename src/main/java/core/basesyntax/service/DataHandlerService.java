package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.List;
import java.util.Map;

public interface DataHandlerService {
    Map<String, Integer> handleData(List<FruitRecord> fruitRecords);
}
