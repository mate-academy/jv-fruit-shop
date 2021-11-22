package core.service.operation;

import core.model.FruitRecord;
import core.model.OperationType;

public class BalanceOperationTypeHandler implements OperationTypeHandler {

    public BalanceOperationTypeHandler() {
    }

    @Override
    public OperationType getOperationType(String string) {
        return OperationType.BALANCE;
    }

    @Override
    public int getUpdateAmount(FruitRecord fruitRecord, int previousAmount) {
        return fruitRecord.getAmount();
    }
}
