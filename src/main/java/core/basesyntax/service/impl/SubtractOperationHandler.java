package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.OperationHandler;

public class SubtractOperationHandler implements OperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Integer currentQuantity = Storage.fruits.get(fruit);
        int newQuantity = currentQuantity - fruitRecordDto.getQuantity();
        if (newQuantity > 0) {
            Storage.fruits.put(fruit, newQuantity);
            return newQuantity;
        } else {
            throw new RuntimeException("Not enough quantity for operation");
        }
    }
}
