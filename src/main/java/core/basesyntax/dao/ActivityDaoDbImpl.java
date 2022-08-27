package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class ActivityDaoDbImpl implements ActivityDaoDb {
    @Override
    public void add(Activity activity) {
        Storage.db.add(activity);
    }

    @Override
    public List<Activity> getAll() {
        return new ArrayList<>(Storage.db);
    }
}
