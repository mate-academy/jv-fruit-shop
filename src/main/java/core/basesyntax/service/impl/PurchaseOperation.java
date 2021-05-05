package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class PurchaseOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruit());
        checkFruits(fruit.getFruitName());
        Integer currentQuantity = Storage.fruits.get(fruit);
        Integer neededQuantity = fruitRecordDto.getQuantity();
        if (currentQuantity == null) {
            throw new RuntimeException("We don't have "
                    + fruitRecordDto.getFruit());
        }
        if (currentQuantity < neededQuantity) {
            throw new RuntimeException("We don't have enough "
                    + fruitRecordDto.getFruit());
        }
        int newQuantity = currentQuantity - neededQuantity;
        Storage.fruits.put(fruit, newQuantity);
        return newQuantity;
    }
}
