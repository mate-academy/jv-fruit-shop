package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitOperationHandler;

public class AddOperationHandler implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Integer currentQuantity = Storage.fruits.get(fruit);
        int newQuantity = currentQuantity + fruitRecordDto.getQuantity();
        Storage.fruits.put(fruit, newQuantity);
        return newQuantity;
    }
}
