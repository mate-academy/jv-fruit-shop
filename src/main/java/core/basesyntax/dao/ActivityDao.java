package core.basesyntax.dao;

import core.basesyntax.model.Activity;
import java.util.List;

public interface ActivityDao {
    List<Activity> getAll(String file);
}
