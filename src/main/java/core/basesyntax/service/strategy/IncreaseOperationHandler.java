package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;

public class IncreaseOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitRecordDto fruitRecord) {
        Fruit fruit = new Fruit(fruitRecord.getFruitName());
        if (!FruitStorage.storage.containsKey(fruit.getFruitName())) {
            FruitStorage.storage.put(fruit.getFruitName(), 0);
        }
        Integer currentQuantity = FruitStorage.storage.get(fruit.getFruitName());
        int newQuantity = currentQuantity + fruitRecord.getQuantity();
        FruitStorage.storage.put(fruit.getFruitName(), newQuantity);
    }
}
