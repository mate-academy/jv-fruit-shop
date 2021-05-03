package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;

public class AddBalanceOperation implements FruitOperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        Integer quantity = fruitRecordDto.getQuantity();
        checkQuantity(quantity);
        String fruitName = fruitRecordDto.getFruitName();
        checkFruitName(fruitName);
        Storage.fruitsDataBase.put(new Fruit(fruitName), quantity);
    }
}
