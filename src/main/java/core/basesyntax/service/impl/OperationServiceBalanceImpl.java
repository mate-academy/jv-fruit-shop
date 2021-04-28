package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.service.OperationService;

public class OperationServiceBalanceImpl implements OperationService {
    @Override
    public void doOperation(FruitDataDto fruitRecordDto) {
        if (!Storage.getFruits().containsKey(new Fruit(fruitRecordDto.getFruitName()))) {
            Storage.getFruits().put(new Fruit(fruitRecordDto.getFruitName()), fruitRecordDto.getFruitQuantity());
        }

    }
}
