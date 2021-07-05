package core.basesyntax.strategy;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Storage;

public class SupplyOperation implements FruitOperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        Integer quantity = fruitRecordDto.getQuantity();
        checkQuantity(quantity);
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        if (Storage.fruitsDataBase.containsKey(fruit)) {
            Storage.fruitsDataBase.put(fruit, Storage.fruitsDataBase.get(fruit) + quantity);
        } else {
            Storage.fruitsDataBase.put(fruit, quantity);
        }
    }
}
