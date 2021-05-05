package core.basesyntax.service.implementation;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.FruitOperationHandler;

public class DecreaseOperationImpl implements FruitOperationHandler {

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Integer currentQuantity = Storage.getFruits().get(fruitRecordDto.getFruitName());
        if (currentQuantity >= fruitRecordDto.getQuantity()) {
            int newQuantity = currentQuantity - fruitRecordDto.getQuantity();
            Storage.getFruits().put(fruitRecordDto.getFruitName(), newQuantity);
            return newQuantity;
        }
        throw new RuntimeException("Haven't enough fruits ");
    }

}
