package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.Operation;

public class AddOperation implements Operation {
    @Override
    public int apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitType());
        checkFruitType(fruit.getType());
        int currentQuantity = (Storage.fruits.get(fruit) == null) ? 0 : Storage.fruits.get(fruit);
        int desiredQantity = fruitRecordDto.getQuantity();
        checkQuantity(desiredQantity);
        int newQuantity = currentQuantity + desiredQantity;

        Storage.fruits.put(fruit, newQuantity);
        return newQuantity;
    }
}
