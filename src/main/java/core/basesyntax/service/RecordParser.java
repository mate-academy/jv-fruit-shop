package core.basesyntax.service;

import core.basesyntax.model.Record;
import java.util.List;

public interface RecordParser {
    List<Record> parseRecords(List<String> records);
}
