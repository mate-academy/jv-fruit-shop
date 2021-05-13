package core.basesyntax.service.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import java.util.Optional;

public class AddOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        String fruitName = fruitRecordDto.getFruitName();
        int quantity = fruitRecordDto.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Incorrect input value: " + quantity);
        }
        int oldQuantity = Optional.ofNullable(Storage.fruitsContainer.get(fruitName)).orElse(0);
        int newQuantity = oldQuantity + quantity;
        Storage.fruitsContainer.put(fruitName, newQuantity);
        return Storage.fruitsContainer.get(fruitName);
    }
}
