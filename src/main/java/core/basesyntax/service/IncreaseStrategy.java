package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.Storage;

public class IncreaseStrategy implements OperationStrategy {

    @Override
    public boolean apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = fruitRecordDto.getFruit();
        if (!Storage.fruitStorage.containsKey(fruit)) {
            Storage.fruitStorage.put(fruit, fruitRecordDto.getQuantity());
        } else {
            Integer currentQuantity = Storage.fruitStorage.get(fruit);
            Storage.fruitStorage.put(fruit, currentQuantity + fruitRecordDto.getQuantity());
        }
        return true;
    }
}
