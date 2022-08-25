package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.Dao;
import core.basesyntax.strategy.PostingGoods;

public class PostingSupplyOfFruit implements PostingGoods {
    @Override
    public void makePosting(FruitMovement movement, Dao dao) {
        Fruit fruit = movement.getFruit();
        int currentAmount = dao.getAmount(fruit);
        currentAmount += movement.getAmount();
        dao.updateBalance(fruit, currentAmount);
    }
}
