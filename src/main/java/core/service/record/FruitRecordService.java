package core.service.record;

import core.model.FruitRecord;
import java.util.List;

public interface FruitRecordService {

    List<FruitRecord> parserFruit(List<String> createList);
}
