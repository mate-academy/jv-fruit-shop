package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.validate.RemoveOperationValidator;
import core.basesyntax.validate.impl.RemoveOperationValidatorImpl;
import java.util.Optional;

public class RemoveOperation implements FruitOperation {
    private RemoveOperationValidator removeOperationValidator
            = new RemoveOperationValidatorImpl();

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Optional<Integer> currentQuantityFruit =
                Optional.ofNullable(Storage.fruits.get(fruit));
        int newValue = 0;
        if (currentQuantityFruit.isPresent()
                && removeOperationValidator
                .removeOperationValidate(currentQuantityFruit.get(),
                        fruitRecordDto.getFruitCount())) {
            newValue = currentQuantityFruit.get() - fruitRecordDto.getFruitCount();
            Storage.fruits.put(fruit, newValue);
        }
        return newValue;
    }
}
