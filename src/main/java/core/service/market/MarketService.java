package core.service.market;

import core.exception.ValidationException;
import core.model.FruitRecord;
import java.util.List;

public interface MarketService {
    void applyOperations(List<FruitRecord> fruitRecordList) throws ValidationException;
}
