package core.basesyntax.strategy;

import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.FruitDao;

public interface GoodHandler {
    void makePosting(FruitMovement movement, FruitDao dao);
}
