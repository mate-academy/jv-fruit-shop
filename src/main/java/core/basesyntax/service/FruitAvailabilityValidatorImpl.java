package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.interfaces.FruitAvailabilityValidator;

public class FruitAvailabilityValidatorImpl implements FruitAvailabilityValidator {

    @Override
    public void checkAvailability(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        if (Storage.getQuantity(fruit) == null) {
            throw new RuntimeException("No such fruit in the store: "
                    + fruitRecordDto.getFruitName());
        }
    }
}
