package core.basesyntax.service.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;

public class AddOperationStrategy implements FruitOperationStrategy {
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
