package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.Dao;
import core.basesyntax.strategy.PostingGoods;

public class PostingBalanceOfFruits implements PostingGoods {

    @Override
    public void makePosting(FruitMovement movement, Dao dao) {
        dao.updateBalance(movement.getFruit(), movement.getAmount());
    }
}
