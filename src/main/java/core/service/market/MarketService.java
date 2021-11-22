package core.service.market;

import core.model.FruitRecord;
import java.util.List;

public interface MarketService {
    void applyOperations(List<FruitRecord> fruitRecordList);
}
