package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.service.OperationService;

public class OperationServiceReturnImpl implements OperationService {
    @Override
    public void doOperation(FruitDataDto fruitRecordDto) {
        Storage.getFruits().put(new Fruit(fruitRecordDto.getFruitName()),
                Storage.getFruits().get(new Fruit(fruitRecordDto.getFruitName()))
                        + fruitRecordDto.getFruitQuantity());
    }
}
