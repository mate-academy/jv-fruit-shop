package core.basesyntax.service.implementation;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.FruitOperationHandler;
import java.util.Optional;

public class DecreaseOperationImpl implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Optional<Integer> currentQuantity = Optional.ofNullable(Storage
                .getFruits().get(fruitRecordDto.getFruitName()));
        if (currentQuantity.isPresent() && currentQuantity.get() >= fruitRecordDto.getQuantity()) {
            int newQuantity = currentQuantity.get() - fruitRecordDto.getQuantity();
            Storage.getFruits().put(fruitRecordDto.getFruitName(), newQuantity);
            return newQuantity;
        }
        throw new RuntimeException("Haven't enough fruits ");
    }
}
