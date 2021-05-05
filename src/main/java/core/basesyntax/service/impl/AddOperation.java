package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperations;

public class AddOperation implements FruitOperations {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        int newQuantity = fruitRecordDto.getQuantity() + Storage.fruits.get(fruit);
        Storage.fruits.put(fruit, newQuantity);
        return Storage.fruits.get(fruit);
    }
}
