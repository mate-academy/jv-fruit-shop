package core.basesyntax.service.activity;

import core.basesyntax.database.FruitDto;

public class BalanceHandler implements ActivityHandler {
    @Override
    public void doActivity(FruitDto fruitDto) {
        fruitsDao.put(fruitDto);
    }
}
