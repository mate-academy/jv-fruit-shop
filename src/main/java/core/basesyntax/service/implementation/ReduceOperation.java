package core.basesyntax.service.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;

public class ReduceOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        String fruitName = fruitRecordDto.getFruitName();
        int quantity = fruitRecordDto.getQuantity();
        int oldQuantity = Storage.fruitsContainer.get(fruitName);
        if (oldQuantity < quantity || quantity < 0) {
            throw new RuntimeException("Incorrect quantity of fruit record");
        }
        int newQuantity = oldQuantity - quantity;
        Storage.fruitsContainer.put(fruitName, newQuantity);
        return Storage.fruitsContainer.get(fruitName);
    }
}
