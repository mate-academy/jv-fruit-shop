package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(FruitDto fruitDto) {
        int fruitQuantity = fruitDto.getQuantity();
        Storage.storage.put(new Fruit(fruitDto.getName()), fruitQuantity);
        return fruitQuantity;
    }
}
