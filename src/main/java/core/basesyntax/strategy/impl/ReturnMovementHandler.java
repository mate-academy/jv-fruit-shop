package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.FruitDao;
import core.basesyntax.strategy.GoodHandler;

public class ReturnMovementHandler implements GoodHandler {
    private final FruitDao fruitDao;

    public ReturnMovementHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void makePosting(FruitMovement movement) {
        fruitDao.addToAmount(movement.getFruit(), movement.getAmount());
    }
}
