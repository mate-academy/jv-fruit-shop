package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperation;

public class BalanceOperation implements FruitOperation {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        int newQuantity = fruitRecordDto.getQuantity();
        Storage.fruits.put(fruit, newQuantity);
        return Storage.fruits.get(fruit);
    }
}
