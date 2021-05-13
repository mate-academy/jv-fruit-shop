package core.basesyntax.service.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class SetOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        String fruitName = fruitRecordDto.getFruitName();
        int quantity = fruitRecordDto.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Incorrect input value: " + quantity);
        }
        Storage.fruitsContainer.put(fruitName,quantity);
        return Storage.fruitsContainer.get(fruitName);
    }
}
