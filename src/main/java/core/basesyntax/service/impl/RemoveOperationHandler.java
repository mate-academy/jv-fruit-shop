package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitOperationHandler;

public class RemoveOperationHandler implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Integer currentQuantity = Storage.fruits.get(fruit);
        if (currentQuantity >= fruitRecordDto.getQuantity()) {
            int newQuantity = currentQuantity - fruitRecordDto.getQuantity();
            Storage.fruits.put(fruit, newQuantity);
            return newQuantity;
        }
        throw new RuntimeException("Not enough fruit to remove: " + currentQuantity);
    }
}
