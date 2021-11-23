package core.basesyntax.strategy.activities;

import core.basesyntax.db.dao.FruitDao;
import core.basesyntax.db.dao.FruitDaoStorage;
import core.basesyntax.model.Activity;

public class BalanceService implements ActivityService {
    private FruitDao fruitDao;

    public BalanceService() {
        this.fruitDao = new FruitDaoStorage();
    }

    @Override
    public void apply(Activity activity) {
        fruitDao.create(activity.getFruit(), activity.getQuantity());
    }
}
