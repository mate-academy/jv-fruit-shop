package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class BalanceOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Integer currentQuantity = fruitRecordDto.getQuantity();
        Storage.fruits.put(fruit, currentQuantity);
        return Storage.fruits.get(fruit);
    }

    @Override
    public String getOperationType() {
        return "b";
    }
}
