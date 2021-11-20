package core.basesyntax.strategy;

import core.basesyntax.db.dao.FruitDao;
import core.basesyntax.db.dao.FruitDaoStorage;
import core.basesyntax.model.Activity;

public class BalanceStrategy implements ActivityStrategy{
    private FruitDao fruitDao;

    public BalanceStrategy() {
        fruitDao = new FruitDaoStorage();
    }

    @Override
    public void apply(Activity activity) {
        fruitDao.create(activity.getFruit());
    }
}
