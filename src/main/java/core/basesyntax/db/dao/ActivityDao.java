package core.basesyntax.db.dao;

import core.basesyntax.strategy.Activity;

public interface ActivityDao {
    void create(Activity activity);
    Activity read(Activity activity);
    void update(Activity activity);
    void delete(Activity activity);
}
