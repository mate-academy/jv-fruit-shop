package core.basesyntax.service.strategy.operation;

import core.basesyntax.model.FruitRecord;

import java.util.Map;

public class BalanceOperationHandlerImpl implements OperationHandler{

    @Override
    public int getAmount(FruitRecord fruitRecord, Map<String, Integer> fruitStorage) {
        fruitStorage.put(fruitRecord.getFruitName(), 0);
        return fruitRecord.getAmount();
    }
}
