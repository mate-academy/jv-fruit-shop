package core.basesyntax.strategy;

import core.basesyntax.db.dao.FruitDao;
import core.basesyntax.db.dao.FruitDaoStorage;
import core.basesyntax.model.Activity;

public class PurchaseStrategy implements ActivityStrategy{
    private FruitDao fruitDao;

    public PurchaseStrategy() {
        fruitDao = new FruitDaoStorage();
    }

    @Override
    public void apply(Activity activity) {

    }
}
