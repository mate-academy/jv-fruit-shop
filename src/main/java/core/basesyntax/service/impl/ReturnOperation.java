package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class ReturnOperation implements FruitOperationHandler {

    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        Integer currentQuantity = Storage.getFruits().get(fruitRecordDto.getFruit());
        if (currentQuantity == null) {
            throw new RuntimeException("We don't have "
                    + fruitRecordDto.getFruit().getFruitName());
        }
        Storage.getFruits().put(fruitRecordDto.getFruit(),
                fruitRecordDto.getQuantity() + currentQuantity);
    }
}
