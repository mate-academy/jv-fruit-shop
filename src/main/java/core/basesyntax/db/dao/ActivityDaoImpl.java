package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.Activity;

public class ActivityDaoImpl implements ActivityDao {
    @Override
    public void create(Activity activity) {
        Storage.activities.add(activity);
    }

    @Override
    public Activity read(Activity activity) {
        return Storage.activities
                .stream()
                .filter(a -> a.equals(activity))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No element was found"));
    }

    @Override
    public void update(Activity activity) {

    }

    @Override
    public void delete(Activity activity) {

    }
}
