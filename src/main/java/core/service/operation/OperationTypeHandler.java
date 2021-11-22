package core.service.operation;

import core.model.FruitRecord;
import core.model.OperationType;

public interface OperationTypeHandler {
    OperationType getOperationType(String string);

    int getUpdateAmount(FruitRecord fruitRecord, int oldAmount);
}
