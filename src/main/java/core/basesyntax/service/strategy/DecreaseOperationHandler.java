package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.validator.Validator;

public class DecreaseOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitRecordDto fruitRecord) {
        Fruit fruit = new Fruit(fruitRecord.getFruitName());
        if (!FruitStorage.storage.containsKey(fruit.getFruitName())) {
            FruitStorage.storage.put(fruit.getFruitName(), 0);
        }
        Integer currentQuantity = FruitStorage.storage.get(fruit.getFruitName());
        int newQuantity = currentQuantity - fruitRecord.getQuantity();
        Validator.canDoPurchase(newQuantity, currentQuantity, fruitRecord);
        FruitStorage.storage.put(fruit.getFruitName(), newQuantity);
    }
}
