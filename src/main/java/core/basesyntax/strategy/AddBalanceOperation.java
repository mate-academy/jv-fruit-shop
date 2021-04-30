package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;

public class AddBalanceOperation implements FruitOperationHandler {
    @Override
    public void apply(FruitRecordDto fruitRecordDto)  {
        Integer quantity =  fruitRecordDto.getQuantity();
        checkQuantity(quantity);
        Storage.fruitsDataBase.put(new Fruit(fruitRecordDto.getFruitName()), fruitRecordDto.getQuantity());
    }
}
