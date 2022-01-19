package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.db.FruitStorage;

public class IncreaseOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitRecordDto fruitRecord) {
        if (!FruitStorage.storage.containsKey(fruitRecord.getFruitName())) {
            FruitStorage.storage.put(fruitRecord.getFruitName(), 0);
        }
        Integer currentQuantity = FruitStorage.storage.get(fruitRecord.getFruitName());
        int newQuantity = currentQuantity + fruitRecord.getQuantity();
        FruitStorage.storage.put(fruitRecord.getFruitName(), newQuantity);
    }
}
