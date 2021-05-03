package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;

public class ReturnOperation implements FruitOperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        Integer quantity = fruitRecordDto.getQuantity();
        checkQuantity(quantity);
        String fruitName = fruitRecordDto.getFruitName();
        checkFruitName(fruitName);

        Fruit fruit = new Fruit(fruitName);
        if (Storage.fruitsDataBase.containsKey(fruit)) {
            Storage.fruitsDataBase.put(fruit, Storage.fruitsDataBase.get(fruit) + quantity);
        } else {
            throw new RuntimeException("This fruit is not in stock - " + fruitName);
        }
    }
}
