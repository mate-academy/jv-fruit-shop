package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.interfaces.FruitOperationHandler;

public class AddOperation implements FruitOperationHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void applyAction(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        int currentQuantity = Storage.fruits.get(fruit) == null
                ? DEFAULT_VALUE
                : Storage.fruits.get(fruit);
        int newQuantity = currentQuantity + fruitRecordDto.getQuantity();
        Storage.fruits.put(fruit, newQuantity);
    }
}
