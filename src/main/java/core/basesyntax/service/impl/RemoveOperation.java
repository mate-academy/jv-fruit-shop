package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.Operation;

public class RemoveOperation implements Operation {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitType());
        checkFruitType(fruit.getType());
        Integer currentQuantity = Storage.fruits.get(fruit);
        int desiredQuantity = fruitRecordDto.getQuantity();
        checkQuantity(desiredQuantity);
        int newQuantity = currentQuantity - desiredQuantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough fruits in the store");
        }
        Storage.fruits.put(fruit, newQuantity);
        return newQuantity;
    }
}
