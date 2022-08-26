package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.FruitDao;
import core.basesyntax.strategy.GoodHandler;

public class PostingPurchaseOfFruit implements GoodHandler {
    @Override
    public void makePosting(FruitMovement movement, FruitDao dao) {
        Fruit fruit = movement.getFruit();
        int currentAmount = dao.getAmount(fruit);
        currentAmount -= movement.getAmount();
        dao.updateBalance(fruit, currentAmount);
    }
}
