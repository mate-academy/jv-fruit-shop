package core.service.operation;

import core.model.FruitRecord;
import core.model.OperationType;

public class PurchaseOperationTypeHandler implements OperationTypeHandler {
    public PurchaseOperationTypeHandler() {
    }

    @Override
    public OperationType getOperationType(String string) {
        return OperationType.PURCHASE;
    }

    @Override
    public int getUpdateAmount(FruitRecord fruitRecord, int previousAmount) {
        if (previousAmount - fruitRecord.getAmount() < 0) {
            throw new RuntimeException("Can't purchase. "
                    + "Current amount is lower than requirement amount");
        }
        return previousAmount - fruitRecord.getAmount();
    }
}
