package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import java.util.Optional;

public class SupplyOperation implements FruitOperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Integer currentQuantity = Optional.ofNullable(Storage.fruits.get(fruit)).orElse(0);
        int supplyAmount = fruitRecordDto.getQuantity();
        if (supplyAmount < 0) {
            throw new RuntimeException("Supply amount can't be less than 0");
        }
        int newQuantity = currentQuantity + supplyAmount;
        Storage.fruits.put(fruit, newQuantity);
        return Storage.fruits.get(fruit);
    }

    @Override
    public String getOperationType() {
        return "s";
    }
}
