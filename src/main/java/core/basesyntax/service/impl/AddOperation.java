package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperation;

import java.util.Optional;

public class AddOperation implements FruitOperation {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        Optional<Integer> currentQuantity =
                Optional.ofNullable(Storage.fruits.get(fruit));
        if (currentQuantity.isPresent()) {
            int newQuantity = currentQuantity.get() + fruitRecordDto.getFruitCount();
            Storage.fruits.put(fruit, newQuantity);
            return newQuantity;
        } else {
            Storage.fruits.put(fruit, fruitRecordDto.getFruitCount());
            return fruitRecordDto.getFruitCount();
        }
    }
}
