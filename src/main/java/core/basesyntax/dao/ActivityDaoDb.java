package core.basesyntax.dao;

import core.basesyntax.model.Activity;
import java.util.List;

public interface ActivityDaoDb {
    void add(Activity activity);

    List<Activity> getAll();
}
