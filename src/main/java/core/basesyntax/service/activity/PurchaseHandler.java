package core.basesyntax.service.activity;

import core.basesyntax.database.FruitDto;

public class PurchaseHandler implements ActivityHandler {
    @Override
    public void doActivity(FruitDto fruitDto) {
        fruitDto.setAmount(-fruitDto.getAmount());
        fruitsDao.put(fruitDto);
    }
}
