package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import java.util.Optional;

public class ReturnOperation implements FruitOperationHandler {

    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Integer currentQuantity = Optional.ofNullable(Storage.fruits.get(fruit)).orElse(0);
        int returnAmount = fruitRecordDto.getQuantity();
        if (returnAmount < 0) {
            throw new RuntimeException("Return amount can't be less than 0");
        }
        int newQuantity = currentQuantity + returnAmount;
        Storage.fruits.put(fruit, newQuantity);
        return Storage.fruits.get(fruit);
    }

    @Override
    public String getOperationType() {
        return "r";
    }
}
