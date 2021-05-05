package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import java.util.Optional;

public class AddOperation implements FruitOperationHandler {

    @Override
    public int applyOperation(FruitRecordDto fruitRecordDto) {
        int newBalance;
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        int adding = fruitRecordDto.getQuantity();
        Optional<Integer> currentQuantity = Optional.ofNullable(Storage.fruits.get(fruit));
        if (currentQuantity.isPresent()) {
            newBalance = currentQuantity.get() + adding;
        } else {
            newBalance = adding;
        }
        Storage.fruits.put(fruit, newBalance);
        return newBalance;
    }
}
