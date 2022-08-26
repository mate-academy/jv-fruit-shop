package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.FruitDao;
import core.basesyntax.strategy.GoodHandler;

public class PostingBalanceOfFruits implements GoodHandler {

    @Override
    public void makePosting(FruitMovement movement, FruitDao dao) {
        dao.updateBalance(movement.getFruit(), movement.getAmount());
    }
}
