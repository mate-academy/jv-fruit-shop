package core.basesyntax.strategy;

import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.Dao;

public interface PostingGoods {
    void makePosting(FruitMovement movement, Dao dao);
}
