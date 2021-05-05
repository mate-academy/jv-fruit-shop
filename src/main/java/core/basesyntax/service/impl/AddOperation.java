package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class AddOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruit());
        checkFruits(fruit.getFruitName());
        Integer currentQuantity = 0;
        if (Storage.fruits.get(fruit) != null) {
            currentQuantity = Storage.fruits.get(fruit);
        }
        Integer neededQuantity = fruitRecordDto.getQuantity();
        checkQuantity(neededQuantity);
        int newQuantity = currentQuantity + neededQuantity;
        Storage.fruits.put(fruit, newQuantity);
        return newQuantity;
    }
}
