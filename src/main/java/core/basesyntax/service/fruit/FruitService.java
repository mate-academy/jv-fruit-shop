package core.basesyntax.service.fruit;

import core.basesyntax.model.fruit.Record;
import java.util.List;
import java.util.Map;

public interface FruitService {
    Map<String, Integer> processRecords(List<Record> records);
}
