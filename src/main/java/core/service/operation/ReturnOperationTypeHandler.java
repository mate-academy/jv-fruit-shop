package core.service.operation;

import core.model.FruitRecord;
import core.model.OperationType;

public class ReturnOperationTypeHandler implements OperationTypeHandler {
    public ReturnOperationTypeHandler() {
    }

    @Override
    public OperationType getOperationType(String string) {
        return OperationType.RETURN;
    }

    @Override
    public int getUpdateAmount(FruitRecord fruitRecord, int previousAmount) {
        return previousAmount + fruitRecord.getAmount();
    }
}
