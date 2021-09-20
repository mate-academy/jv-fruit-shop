package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface RecordParserService {
    List<FruitRecord> parseRecords(String fileName);
}
