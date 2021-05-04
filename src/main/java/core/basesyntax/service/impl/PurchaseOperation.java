package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class PurchaseOperation implements FruitOperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        Integer currentQuantity = Storage.getFruits().get(fruitRecordDto.getFruit());
        Integer neededQuantity = fruitRecordDto.getQuantity();
        if (currentQuantity == null) {
            throw new RuntimeException("We don't have "
                    + fruitRecordDto.getFruit().getFruitName());
        }
        if (currentQuantity < neededQuantity) {
            throw new RuntimeException("We don't have enough "
                    + fruitRecordDto.getFruit().getFruitName());
        }
        Storage.getFruits().put(fruitRecordDto.getFruit(),
                currentQuantity - neededQuantity);

    }
}
