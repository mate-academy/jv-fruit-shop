package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Storage.fruits.put(fruit, fruitRecordDto.getQuantity());
        return fruitRecordDto.getQuantity();
    }
}

