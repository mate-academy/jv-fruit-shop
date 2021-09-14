package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface RecordListMakerService {
    List<FruitRecord> getFruitRecordList(List<String> list);
}
