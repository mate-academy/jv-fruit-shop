package core.basesyntax.service.implementation;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.FruitOperationHandler;

public class SetOperation implements FruitOperationHandler {

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        String fruitName = fruitRecordDto.getFruitName();
        int quantity = fruitRecordDto.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Incorrect input value: " + quantity);
        }
        Storage.getFruits().put(fruitName, quantity);
        return Storage.getFruits().get(fruitName);
    }
}
