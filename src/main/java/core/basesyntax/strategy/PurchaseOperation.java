package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;

public class PurchaseOperation implements FruitOperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        if (!Storage.fruitsDataBase.containsKey(fruit)) {
            throw new RuntimeException("This fruit is not in stock - " + fruit.getType());
        }

        Integer wishQuantity = fruitRecordDto.getQuantity();
        checkQuantity(wishQuantity);
        Integer currentQuantity = Storage.fruitsDataBase.get(fruit);
        if (wishQuantity > currentQuantity) {
            throw new RuntimeException("The quantity of fruit in stock is not available");
        }

        Storage.fruitsDataBase.put(fruit, currentQuantity - wishQuantity);
    }
}
