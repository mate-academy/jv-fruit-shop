package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface RecordsParserService {
    List<FruitRecord> parseRecords(String fileName);
}
