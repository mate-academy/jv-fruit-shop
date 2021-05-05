package core.basesyntax.service.implementation;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.FruitOperationHandler;

public class IncreaseOperationImpl implements FruitOperationHandler {

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Integer currentQuantity = Storage.getFruits().get(fruitRecordDto.getFruitName());
        if (fruitRecordDto.getQuantity() > 0) {
            int newQuantity = currentQuantity + fruitRecordDto.getQuantity();
            Storage.getFruits().put(fruitRecordDto.getFruitName(), newQuantity);
            return currentQuantity + fruitRecordDto.getQuantity();
        }
        throw new RuntimeException("Wrong quantity of fruits: " + fruitRecordDto.getQuantity());
    }
}
