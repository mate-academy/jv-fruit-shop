package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.validator.Validator;

public class DecreaseOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitRecordDto fruitRecord) {
        if (!FruitStorage.storage.containsKey(fruitRecord.getFruitName())) {
            FruitStorage.storage.put(new Fruit(fruitRecord.getFruitName().toString()), 0);
        }
        Integer currentQuantity = FruitStorage.storage.get(fruitRecord.getFruitName());
        int newQuantity = currentQuantity - fruitRecord.getQuantity();
        Validator.canDoPurchase(newQuantity, currentQuantity, fruitRecord);
        FruitStorage.storage.put(fruitRecord.getFruitName(), newQuantity);
    }
}
