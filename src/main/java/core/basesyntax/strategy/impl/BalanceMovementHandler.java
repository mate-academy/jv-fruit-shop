package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.FruitDao;
import core.basesyntax.strategy.GoodHandler;

public class BalanceMovementHandler implements GoodHandler {
    private final FruitDao fruitDao;

    public BalanceMovementHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void makePosting(FruitMovement movement) {
        fruitDao.updateBalance(movement.getFruit(), movement.getAmount());
    }
}
