package core.basesyntax.service.strategy.operation;

import core.basesyntax.model.FruitRecord;

import java.util.Map;

public class SupplyOperationHandlerImpl implements OperationHandler{

    @Override
    public int getAmount(FruitRecord fruitRecord, Map<String, Integer> fruitStorage) {
        for (Map.Entry<String, Integer> fruitRecordEntry : fruitStorage.entrySet()) {
            if (fruitRecordEntry.getKey().equals(fruitRecord.getFruitName())) {
                return fruitRecordEntry.getValue() + fruitRecord.getAmount();
            }
        }
        return 0;
    }
}
