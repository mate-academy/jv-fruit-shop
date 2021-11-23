package core.basesyntax.strategy.activities;

import core.basesyntax.db.dao.FruitDao;
import core.basesyntax.db.dao.FruitDaoStorage;
import core.basesyntax.model.Activity;

public class SupplyService implements ActivityService {
    private FruitDao fruitDao;

    public SupplyService() {
        this.fruitDao = new FruitDaoStorage();
    }

    @Override
    public void apply(Activity activity) {
        fruitDao.update(activity.getFruit(),
                fruitDao.read(activity.getFruit()) + activity.getQuantity());
    }
}
