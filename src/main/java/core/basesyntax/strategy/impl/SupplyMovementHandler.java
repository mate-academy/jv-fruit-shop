package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.FruitDao;
import core.basesyntax.strategy.GoodHandler;

public class SupplyMovementHandler implements GoodHandler {
    private final FruitDao fruitDao;

    public SupplyMovementHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void makePosting(FruitMovement movement) {
        fruitDao.addToAmount(movement.getFruit(), movement.getAmount());
    }
}
