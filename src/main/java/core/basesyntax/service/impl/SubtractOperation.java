package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.DataValidation;
import core.basesyntax.service.FruitOperationHandler;
import java.util.Optional;

public class SubtractOperation implements FruitOperationHandler {
    private DataValidation subtractValidation = new DataValidationImpl();

    @Override
    public int applyOperation(FruitRecordDto fruitRecordDto) {
        int newBalance = 0;
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        int subtracting = fruitRecordDto.getQuantity();
        Optional<Integer> currentQuantity = Optional.ofNullable(Storage.fruits.get(fruit));
        if (currentQuantity.isPresent()) {
            if (subtractValidation.subtractCheck(currentQuantity.get(), subtracting)) {
                newBalance = currentQuantity.get() - subtracting;
            }
        } else {
            int current = 0;
            if (subtractValidation.subtractCheck(current, subtracting)) {
                newBalance = current - subtracting;
            }
        }
        Storage.fruits.put(fruit, newBalance);
        return newBalance;
    }
}
