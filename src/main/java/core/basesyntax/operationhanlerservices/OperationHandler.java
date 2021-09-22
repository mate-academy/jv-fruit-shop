package core.basesyntax.operationhanlerservices;

import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public interface OperationHandler {
    void apply(FruitRecordDto fruitRecordDto, Map<String, Integer> map);
}
