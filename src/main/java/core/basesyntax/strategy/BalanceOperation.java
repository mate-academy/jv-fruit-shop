package core.basesyntax.strategy;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Storage;

public class BalanceOperation implements FruitOperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto) {
        Integer quantity = fruitRecordDto.getQuantity();
        checkQuantity(quantity);
        Storage.fruitsDataBase.put(new Fruit(fruitRecordDto.getFruitName()),
                quantity);
    }
}
