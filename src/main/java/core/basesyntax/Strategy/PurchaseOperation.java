package core.basesyntax.Strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;

public class PurchaseOperation implements FruitOperationHandler{
    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        Fruit fruit = new Fruit(fruitRecordDto.getFruitName());
        if(!Storage.fruitsDataBase.containsKey(fruit)) {
            throw new RuntimeException("There's no such fruit in the shop...");
        }

        Integer wishQuantity = fruitRecordDto.getQuantity();
        checkQuantity(wishQuantity);

        Integer currentQuantity = Storage.fruitsDataBase.get(fruit);
        if(wishQuantity > currentQuantity) {
            throw new RuntimeException("Such amount of fruits is not available...");
        }
        Storage.fruitsDataBase.put(fruit, currentQuantity - wishQuantity);
    }
}
