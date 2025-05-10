package core.basesyntax.service;

import core.basesyntax.record.Record;
import java.util.List;

public interface DataProcessingService {
    void processData(List<Record> lines);
}
