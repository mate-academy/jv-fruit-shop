package core.basesyntax.service.strategy.operation;

import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public interface OperationHandler {
    int getAmount(FruitRecordDto fruitRecord);
}
