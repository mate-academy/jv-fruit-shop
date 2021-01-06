package core.basesyntax.service;

import core.basesyntax.model.Record;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void applyOperationOnRecord(List<Record> records);

    Map<String, Long> getFruitReport();
}
