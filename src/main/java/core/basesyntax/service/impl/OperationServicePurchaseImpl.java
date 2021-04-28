package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.service.OperationService;

public class OperationServicePurchaseImpl implements OperationService {
    @Override
    public void doOperation(FruitDataDto fruitRecordDto) {
        if (fruitRecordDto.getFruitQuantity() > Storage.getFruits()
                .get(new Fruit(fruitRecordDto.getFruitName()))) {
            throw new RuntimeException("The number of purchased fruits cannot exceed the actual value");
        }
        Storage.getFruits().put(new Fruit(fruitRecordDto.getFruitName()),
                Storage.getFruits().get(new Fruit(fruitRecordDto.getFruitName()))
                        + fruitRecordDto.getFruitQuantity());
    }
}
