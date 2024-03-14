package core.basesyntax.service;

import core.basesyntax.record.Record;
import java.util.List;

public interface RecordMapper {
    String COMMA = ",";
    int OPERATION_INDEX = 0;
    int PRODUCT_INDEX = 1;
    int QUANTITY_INDEX = 2;
    List<Record> getRecordsFromLines(List<String> lines);
}
