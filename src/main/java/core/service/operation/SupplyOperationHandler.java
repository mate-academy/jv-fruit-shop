package core.service.operation;

import core.model.FruitRecord;
import core.model.OperationType;

public class SupplyOperationHandler implements OperationTypeHandler {
    public SupplyOperationHandler() {
    }

    @Override
    public OperationType getOperationType(String string) {
        return OperationType.SUPPLY;
    }

    @Override
    public int getUpdateAmount(FruitRecord fruitRecord, int previousAmount) {
        return previousAmount + fruitRecord.getAmount();
    }
}
