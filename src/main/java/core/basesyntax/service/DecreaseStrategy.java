package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.Storage;

public class DecreaseStrategy implements OperationStrategy {
    @Override
    public boolean apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = fruitRecordDto.getFruit();
        Integer currentQuantity = Storage.fruitStorage.get(fruit);
        Integer requestedQuantity = fruitRecordDto.getQuantity();
        if (currentQuantity < requestedQuantity) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + requestedQuantity + " " + fruit
                    + " units, because they are only " + currentQuantity
                    + " units in stock.");
        }
        Storage.fruitStorage.put(fruit, currentQuantity - requestedQuantity);
        return true;
    }
}
