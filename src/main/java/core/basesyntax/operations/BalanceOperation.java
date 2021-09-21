package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperationDto;

public class BalanceOperation implements OperationHandler {
    @Override
    public int changeQuantity(FruitOperationDto fruitOperationDto) {
        Storage.storage.put(fruitOperationDto.getFruit(), fruitOperationDto.getQuantity());
        return fruitOperationDto.getQuantity();
    }
}
