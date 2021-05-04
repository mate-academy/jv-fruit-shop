package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class PurchaseOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        if (!Storage.fruits.containsKey(fruit)) {
            throw new RuntimeException("You can't sell this fruit");
        }
        Integer oldQuantity = Storage.fruits.get(fruit);
        Integer newQuantity = oldQuantity - fruitRecordDto.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("The quantity is not available");
        }
        Storage.fruits.put(fruit, newQuantity);
        return newQuantity;
    }
}
