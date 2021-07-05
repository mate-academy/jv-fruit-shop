package core.basesyntax.srategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class BalanceHandler implements OperationHandler {
    @Override
    public int apply(FruitDto fruitDto) {
        Storage.storage.put(new Fruit(fruitDto.getName()), fruitDto.getCount());
        return fruitDto.getCount();
    }
}
