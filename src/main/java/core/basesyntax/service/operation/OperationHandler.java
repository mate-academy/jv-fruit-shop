package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public interface OperationHandler {
    int getAmount(FruitRecordDto fruitRecordDto,  Map<String, Integer> fruitsStorage);
}
