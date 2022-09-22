package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitDto;

public class BalanceOperation implements TypeHandler {

    @Override
    public void handle(FruitDto fruitDto) {
        Storage.fruits.put(fruitDto.getFruit(), fruitDto.getQuantity());
    }
}
