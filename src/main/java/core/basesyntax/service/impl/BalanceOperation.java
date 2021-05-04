package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class BalanceOperation implements FruitOperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        if (fruitRecordDto.getFruit() == null
                || fruitRecordDto.getQuantity() == null) {
            throw new RuntimeException("Data is incorrect");
        }
        Storage.getFruits().put(fruitRecordDto.getFruit(), fruitRecordDto.getQuantity());
    }
}
